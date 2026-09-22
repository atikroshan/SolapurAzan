package com.example.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.AzanRepository
import com.example.data.AzanTiming
import com.example.data.PrayerLog
import com.example.data.PreferencesRepository
import com.example.service.AlarmScheduler
import com.example.worker.PrayerWorkScheduler
import android.content.Context
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import java.util.Calendar

data class UIState(
    val language: String = "en",
    val todayTimings: AzanTiming? = null,
    val fajrEnabled: Boolean = true,
    val dhuhrEnabled: Boolean = true,
    val asrEnabled: Boolean = true,
    val maghribEnabled: Boolean = true,
    val ishaEnabled: Boolean = true,
    val selectedDate: Calendar = Calendar.getInstance(java.util.TimeZone.getTimeZone("Asia/Kolkata")),
    val fajrPrayed: Boolean = false,
    val dhuhrPrayed: Boolean = false,
    val asrPrayed: Boolean = false,
    val maghribPrayed: Boolean = false,
    val ishaPrayed: Boolean = false,
    val tahajjudPrayed: Boolean = false,
    val allLogs: List<PrayerLog> = emptyList()
)

class AzanViewModel(
    private val context: Context,
    private val repository: AzanRepository,
    private val prefs: PreferencesRepository,
    private val alarmScheduler: AlarmScheduler
) : ViewModel() {

    private val _currentCalendar = MutableStateFlow(Calendar.getInstance(java.util.TimeZone.getTimeZone("Asia/Kolkata")))

    fun refreshDate() {
        val today = Calendar.getInstance(java.util.TimeZone.getTimeZone("Asia/Kolkata"))
        val current = _currentCalendar.value
        // If the app is left open, and midnight passes, we should update the date if they were viewing "today"
        // Since we don't know if they were viewing "today" yesterday, we'll just check if we need to update.
        // Actually, just avoid emitting a new Calendar unless the day actually doesn't match the intended day.
        // The simplest fix to stop infinite recomposition is to just NOT reassign if the day is already correct.
    }

    fun nextDay() {
        val next = Calendar.getInstance(java.util.TimeZone.getTimeZone("Asia/Kolkata")).apply {
            timeInMillis = _currentCalendar.value.timeInMillis
            add(Calendar.DAY_OF_MONTH, 1)
        }
        _currentCalendar.value = next
    }

    fun previousDay() {
        val prev = Calendar.getInstance(java.util.TimeZone.getTimeZone("Asia/Kolkata")).apply {
            timeInMillis = _currentCalendar.value.timeInMillis
            add(Calendar.DAY_OF_MONTH, -1)
        }
        _currentCalendar.value = prev
    }

    fun selectToday() {
        _currentCalendar.value = Calendar.getInstance(java.util.TimeZone.getTimeZone("Asia/Kolkata"))
    }

    fun selectDate(month: Int, day: Int) {
        val cal = Calendar.getInstance(java.util.TimeZone.getTimeZone("Asia/Kolkata")).apply {
            set(Calendar.MONTH, month - 1)
            set(Calendar.DAY_OF_MONTH, day)
        }
        _currentCalendar.value = cal
    }

    fun togglePrayerPrayed(name: String) {
        val cal = _currentCalendar.value
        val m = cal.get(Calendar.MONTH) + 1
        val d = cal.get(Calendar.DAY_OF_MONTH)
        togglePrayerForDate(m, d, name)
    }

    fun togglePrayerForDate(month: Int, day: Int, name: String) {
        viewModelScope.launch {
            val todayCal = Calendar.getInstance(java.util.TimeZone.getTimeZone("Asia/Kolkata"))
            val isToday = (month == todayCal.get(Calendar.MONTH) + 1 && day == todayCal.get(Calendar.DAY_OF_MONTH))

            val currentLog = repository.getLogForDateSync(month, day) ?: PrayerLog(month = month, day = day)
            val isCurrentlyPrayed = when (name) {
                "Fajr" -> currentLog.fajrPrayed
                "Dhuhr" -> currentLog.dhuhrPrayed
                "Asr" -> currentLog.asrPrayed
                "Maghrib" -> currentLog.maghribPrayed
                "Isha" -> currentLog.ishaPrayed
                "Tahajjud" -> currentLog.tahajjudPrayed
                else -> false
            }

            // Do not allow marking as prayed before the prayer time has arrived today
            if (isToday && !isCurrentlyPrayed) {
                val timings = repository.getTimingsForDateSync(month, day)
                val isFriday = todayCal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY
                val timeStr = when (name) {
                    "Fajr" -> timings?.fajr
                    "Dhuhr" -> if (isFriday) "12:30" else timings?.dhuhr
                    "Asr" -> timings?.asr
                    "Maghrib" -> timings?.maghrib
                    "Isha" -> timings?.isha
                    "Tahajjud" -> "01:30"
                    else -> null
                }
                if (timeStr != null) {
                    val parts = timeStr.split(":")
                    if (parts.size == 2) {
                        val prayerCal = Calendar.getInstance(java.util.TimeZone.getTimeZone("Asia/Kolkata")).apply {
                            set(Calendar.HOUR_OF_DAY, parts[0].toIntOrNull() ?: 0)
                            set(Calendar.MINUTE, parts[1].toIntOrNull() ?: 0)
                            set(Calendar.SECOND, 0)
                            set(Calendar.MILLISECOND, 0)
                            add(Calendar.MINUTE, 20) // Only allow marking 20 min after Azan time
                        }
                        if (todayCal.before(prayerCal)) {
                            // Prayer time yet to arrive
                            return@launch
                        }
                    }
                }
            }

            val updatedLog = when (name) {
                "Fajr" -> currentLog.copy(fajrPrayed = !currentLog.fajrPrayed)
                "Dhuhr" -> currentLog.copy(dhuhrPrayed = !currentLog.dhuhrPrayed)
                "Asr" -> currentLog.copy(asrPrayed = !currentLog.asrPrayed)
                "Maghrib" -> currentLog.copy(maghribPrayed = !currentLog.maghribPrayed)
                "Isha" -> currentLog.copy(ishaPrayed = !currentLog.ishaPrayed)
                "Tahajjud" -> currentLog.copy(tahajjudPrayed = !currentLog.tahajjudPrayed)
                else -> currentLog
            }
            repository.insertLog(updatedLog)
        }
    }

    private val togglesFlow = combine(
        prefs.isAzanEnabled("Fajr"),
        prefs.isAzanEnabled("Dhuhr"),
        prefs.isAzanEnabled("Asr"),
        prefs.isAzanEnabled("Maghrib"),
        prefs.isAzanEnabled("Isha")
    ) { f, d, a, m, i ->
        listOf(f, d, a, m, i)
    }

    @OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
    private val timingsFlow = _currentCalendar.flatMapLatest { cal ->
        val m = cal.get(Calendar.MONTH) + 1
        val d = cal.get(Calendar.DAY_OF_MONTH)
        val isFriday = cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY
        repository.getTimingsForDate(m, d).map { timing ->
            if (isFriday && timing != null) {
                timing.copy(dhuhr = "12:30")
            } else {
                timing
            }
        }
    }

    @OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
    val uiState: StateFlow<UIState> = combine(
        prefs.languageFlow,
        togglesFlow,
        _currentCalendar,
        repository.getAllLogs(),
        timingsFlow
    ) { language, toggles, cal, allLogs, timings ->
        val m = cal.get(Calendar.MONTH) + 1
        val d = cal.get(Calendar.DAY_OF_MONTH)
        val currentLog = allLogs.find { it.month == m && it.day == d }
        
        UIState(
            language = language,
            todayTimings = timings,
            fajrEnabled = toggles[0],
            dhuhrEnabled = toggles[1],
            asrEnabled = toggles[2],
            maghribEnabled = toggles[3],
            ishaEnabled = toggles[4],
            selectedDate = cal,
            fajrPrayed = currentLog?.fajrPrayed ?: false,
            dhuhrPrayed = currentLog?.dhuhrPrayed ?: false,
            asrPrayed = currentLog?.asrPrayed ?: false,
            maghribPrayed = currentLog?.maghribPrayed ?: false,
            ishaPrayed = currentLog?.ishaPrayed ?: false,
            tahajjudPrayed = currentLog?.tahajjudPrayed ?: false,
            allLogs = allLogs
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), UIState())

    private data class AlarmScheduleState(
        val f: Boolean,
        val d: Boolean,
        val a: Boolean,
        val m: Boolean,
        val i: Boolean,
        val timings: AzanTiming?
    )

    init {
        viewModelScope.launch {
            repository.initializeDatabaseIfNeeded()
            PrayerWorkScheduler.scheduleAllPrayerNotifications(context)
            // Schedule alarms only when toggles or daily timings actually change (ignoring checkbox/languages/logs updates)
            launch {
                uiState.map { state ->
                    AlarmScheduleState(
                        f = state.fajrEnabled,
                        d = state.dhuhrEnabled,
                        a = state.asrEnabled,
                        m = state.maghribEnabled,
                        i = state.ishaEnabled,
                        timings = state.todayTimings
                    )
                }
                .distinctUntilChanged()
                .collect { s ->
                    s.timings?.let { t ->
                        if (s.f) alarmScheduler.scheduleAzan("Fajr", t.fajr) else alarmScheduler.cancelAzan("Fajr")
                        if (s.d) alarmScheduler.scheduleAzan("Dhuhr", t.dhuhr) else alarmScheduler.cancelAzan("Dhuhr")
                        if (s.a) alarmScheduler.scheduleAzan("Asr", t.asr) else alarmScheduler.cancelAzan("Asr")
                        if (s.m) alarmScheduler.scheduleAzan("Maghrib", t.maghrib) else alarmScheduler.cancelAzan("Maghrib")
                        if (s.i) alarmScheduler.scheduleAzan("Isha", t.isha) else alarmScheduler.cancelAzan("Isha")
                        // Refresh WorkManager notification schedules
                        PrayerWorkScheduler.scheduleAllPrayerNotifications(context)
                    }
                }
            }
        }
    }

    fun setLanguage(lang: String) {
        viewModelScope.launch {
            prefs.setLanguage(lang)
        }
    }

    fun toggleAzan(name: String, enabled: Boolean) {
        viewModelScope.launch {
            prefs.setAzanToggle(name, enabled)
            if (!enabled) {
                PrayerWorkScheduler.cancelPrayerNotification(context, name)
            } else {
                PrayerWorkScheduler.scheduleAllPrayerNotifications(context)
            }
        }
    }
}
