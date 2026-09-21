package com.example.data

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class AzanRepository(
    private val context: Context,
    private val azanDao: AzanDao,
    private val prayerLogDao: PrayerLogDao
) {

    fun getTimingsForDate(month: Int, day: Int): Flow<AzanTiming?> = azanDao.getTimingsForDate(month, day)
    
    suspend fun getTimingsForDateSync(month: Int, day: Int): AzanTiming? = azanDao.getTimingsForDateSync(month, day)

    fun getAllLogs(): Flow<List<PrayerLog>> = prayerLogDao.getAllLogs()

    fun getLogForDate(month: Int, day: Int): Flow<PrayerLog?> = prayerLogDao.getLogForDate(month, day)

    suspend fun getLogForDateSync(month: Int, day: Int): PrayerLog? = prayerLogDao.getLogForDateSync(month, day)

    suspend fun insertLog(log: PrayerLog) = prayerLogDao.insertLog(log)

    suspend fun initializeDatabaseIfNeeded() {
        withContext(Dispatchers.IO) {
            val sampleJune6 = azanDao.getTimingsForDateSync(6, 6)
            val needsRecreation = sampleJune6 == null || sampleJune6.dhuhr != "13:15" || sampleJune6.asr != "17:15" || sampleJune6.isha != "20:00"
            if (!needsRecreation) {
                // Database is already fully populated with latest Isha 8:00 PM timings, return instantly!
                return@withContext
            }
            azanDao.deleteAll()
            val sampleEntities = mutableListOf<AzanTiming>()
            for (m in 1..12) {
                for (d in 1..31) {
                    // Create a realistic seasonal shift based on solar zenith changes
                    val dayOfSequence = m * 30 + d
                    val shiftMinutes = (kotlin.math.sin(dayOfSequence.toDouble() / 365.0 * 2.0 * kotlin.math.PI - kotlin.math.PI / 2.0) * 28.0).toInt()
                    
                    sampleEntities.add(
                        AzanTiming(
                            month = m,
                            day = d,
                            fajr = formatTimeWithShift(4, 30, -shiftMinutes),
                            dhuhr = "13:15",
                            asr = "17:15",
                            maghrib = formatTimeWithShift(18, 45, shiftMinutes),
                            isha = "20:00"
                        )
                    )
                }
            }
            azanDao.insertAll(sampleEntities)
        }
    }

    private fun formatTimeWithShift(baseHour: Int, baseMin: Int, shiftMinutes: Int): String {
        var totalMin = baseHour * 60 + baseMin + shiftMinutes
        if (totalMin < 0) totalMin += 1440
        totalMin %= 1440
        val h = totalMin / 60
        val m = totalMin % 60
        return String.format(java.util.Locale.US, "%02d:%02d", h, m)
    }
}
