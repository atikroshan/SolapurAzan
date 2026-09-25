package com.example.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.data.AzanRepository
import com.example.data.AzanTiming
import com.example.data.PrayerLog
import com.example.data.PreferencesRepository
import com.example.data.MasjidItem
import com.example.data.MasjidRepository
import com.example.data.applyMasjidOffsets
import com.example.data.adjustTime
import com.example.service.AlarmScheduler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.TimeZone

data class UIState(
    val language: String = "en",
    val todayTimings: AzanTiming? = null,
    val fajrEnabled: Boolean = true,
    val dhuhrEnabled: Boolean = true,
    val asrEnabled: Boolean = true,
    val maghribEnabled: Boolean = true,
    val ishaEnabled: Boolean = true,
    val selectedDate: Calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata")),
    val fajrPrayed: Boolean = false,
    val dhuhrPrayed: Boolean = false,
    val asrPrayed: Boolean = false,
    val maghribPrayed: Boolean = false,
    val ishaPrayed: Boolean = false,
    val tahajjudPrayed: Boolean = false,
    val allLogs: List<PrayerLog> = emptyList(),
    val customJammatTimes: Map<String, String> = emptyMap(),
    val customJumahAzan: String? = null,
    val selectedMasjid: MasjidItem = MasjidRepository.defaultMasjid,
    val allMasajid: List<MasjidItem> = MasjidRepository.masajid
)

class AzanViewModel(
    private val context: Context,
    private val repository: AzanRepository,
    private val prefs: PreferencesRepository,
    private val alarmScheduler: AlarmScheduler
) : ViewModel() {

    private val _currentCalendar = MutableStateFlow(Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata")))

    fun nextDay() {
        val next = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata")).apply {
            timeInMillis = _currentCalendar.value.timeInMillis
            add(Calendar.DAY_OF_MONTH, 1)
        }
        _currentCalendar.value = next
    }

    fun previousDay() {
        val prev = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata")).apply {
            timeInMillis = _currentCalendar.value.timeInMillis
            add(Calendar.DAY_OF_MONTH, -1)
        }
        _currentCalendar.value = prev
    }

    fun selectToday() {
        _currentCalendar.value = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata"))
    }

    fun refreshDate() {
        _currentCalendar.value = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata"))
    }

    fun selectDate(month: Int, day: Int) {
        val cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata")).apply {
            timeInMillis = _currentCalendar.value.timeInMillis
            set(Calendar.MONTH, month - 1)
            set(Calendar.DAY_OF_MONTH, day)
        }
        _currentCalendar.value = cal
    }

    fun togglePrayerPrayed(name: String) {
        togglePrayed(name)
    }

    fun togglePrayerForDate(month: Int, day: Int, name: String) {
        viewModelScope.launch {
            val currentLog = uiState.value.allLogs.find { it.month == month && it.day == day }
                ?: PrayerLog(month = month, day = day)

            val updatedLog = when (name.lowercase()) {
                "fajr" -> currentLog.copy(fajrPrayed = !currentLog.fajrPrayed)
                "dhuhr", "zohr", "jum'ah" -> currentLog.copy(dhuhrPrayed = !currentLog.dhuhrPrayed)
                "asr" -> currentLog.copy(asrPrayed = !currentLog.asrPrayed)
                "maghrib" -> currentLog.copy(maghribPrayed = !currentLog.maghribPrayed)
                "isha" -> currentLog.copy(ishaPrayed = !currentLog.ishaPrayed)
                "tahajjud" -> currentLog.copy(tahajjudPrayed = !currentLog.tahajjudPrayed)
                else -> currentLog
            }
            repository.insertLog(updatedLog)
        }
    }

    fun updatePrayerTime(prayerName: String, newTime: String, applyToAll: Boolean = false) {
        val cal = _currentCalendar.value
        val m = cal.get(Calendar.MONTH) + 1
        val d = cal.get(Calendar.DAY_OF_MONTH)
        viewModelScope.launch {
            repository.updatePrayerTime(m, d, prayerName, newTime, applyToAll)
        }
    }

    fun togglePrayed(name: String) {
        viewModelScope.launch {
            val cal = _currentCalendar.value
            val month = cal.get(Calendar.MONTH) + 1
            val day = cal.get(Calendar.DAY_OF_MONTH)

            val currentLog = uiState.value.allLogs.find { it.month == month && it.day == day }
                ?: PrayerLog(month = month, day = day)

            val updatedLog = when (name.lowercase()) {
                "fajr" -> currentLog.copy(fajrPrayed = !currentLog.fajrPrayed)
                "dhuhr", "zohr", "jum'ah" -> currentLog.copy(dhuhrPrayed = !currentLog.dhuhrPrayed)
                "asr" -> currentLog.copy(asrPrayed = !currentLog.asrPrayed)
                "maghrib" -> currentLog.copy(maghribPrayed = !currentLog.maghribPrayed)
                "isha" -> currentLog.copy(ishaPrayed = !currentLog.ishaPrayed)
                "tahajjud" -> currentLog.copy(tahajjudPrayed = !currentLog.tahajjudPrayed)
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

    val uiState: StateFlow<UIState> = combine(
        combine(prefs.languageFlow, togglesFlow, _currentCalendar, prefs.selectedMasjidIdFlow) { l, t, c, mId -> 
            val masjid = MasjidRepository.getMasjidById(mId)
            Triple(l, t, Pair(c, masjid))
        },
        repository.getAllLogs(),
        timingsFlow,
        combine(prefs.getAllCustomJammatTimes(), prefs.getCustomJumahAzan()) { cj, ja -> Pair(cj, ja) }
    ) { (language, toggles, calMasjidPair), allLogs, timings, (customJammat, customJumahAzan) ->
        val (cal, selectedMasjid) = calMasjidPair
        val m = cal.get(Calendar.MONTH) + 1
        val d = cal.get(Calendar.DAY_OF_MONTH)
        val isFriday = cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY
        val currentLog = allLogs.find { it.month == m && it.day == d }

        // Adjust timings according to the selected Masjid
        val adjustedTimings = timings?.applyMasjidOffsets(selectedMasjid)

        val effectiveTimings = if (isFriday && adjustedTimings != null) {
            val jumahAzan = customJumahAzan ?: adjustTime(selectedMasjid.jumahAzanTime, selectedMasjid.dhuhrOffset)
            adjustedTimings.copy(dhuhr = jumahAzan)
        } else {
            adjustedTimings
        }

        UIState(
            language = language,
            todayTimings = effectiveTimings,
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
            allLogs = allLogs,
            customJammatTimes = customJammat,
            customJumahAzan = customJumahAzan,
            selectedMasjid = selectedMasjid,
            allMasajid = MasjidRepository.masajid
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), UIState())

    fun selectMasjid(masjidId: String) {
        viewModelScope.launch {
            prefs.setSelectedMasjidId(masjidId)
        }
    }

    fun updatePrayerAndJammatTime(prayerName: String, newAzanTime: String, newJammatTime: String) {
        val cal = _currentCalendar.value
        val m = cal.get(Calendar.MONTH) + 1
        val d = cal.get(Calendar.DAY_OF_MONTH)
        viewModelScope.launch {
            if (prayerName.equals("Jumah", ignoreCase = true) || prayerName.equals("Jum'ah", ignoreCase = true)) {
                prefs.setCustomJumahAzan(newAzanTime)
                prefs.setCustomJammatTime("jumah", newJammatTime)
            } else {
                val dbName = if (prayerName.equals("Zohar", ignoreCase = true)) "dhuhr" else prayerName
                repository.updatePrayerTime(m, d, dbName, newAzanTime, applyToAll = true)
                prefs.setCustomJammatTime(dbName, newJammatTime)
            }
        }
    }

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
                alarmScheduler.cancelAzan(name)
            }
        }
    }
}

class AzanViewModelFactory(
    private val context: Context,
    private val repository: AzanRepository,
    private val prefs: PreferencesRepository,
    private val alarmScheduler: AlarmScheduler
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AzanViewModel(context, repository, prefs, alarmScheduler) as T
    }
}
