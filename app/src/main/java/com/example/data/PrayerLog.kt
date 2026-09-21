package com.example.data

import androidx.room.Entity

@Entity(tableName = "prayer_logs", primaryKeys = ["month", "day"])
data class PrayerLog(
    val month: Int,
    val day: Int,
    val tahajjudPrayed: Boolean = false,
    val fajrPrayed: Boolean = false,
    val dhuhrPrayed: Boolean = false,
    val asrPrayed: Boolean = false,
    val maghribPrayed: Boolean = false,
    val ishaPrayed: Boolean = false
) {
    fun isPerfectDay(): Boolean {
        return tahajjudPrayed && fajrPrayed && dhuhrPrayed && asrPrayed && maghribPrayed && ishaPrayed
    }

    fun getCompletedPrayersCount(): Int {
        var count = 0
        if (tahajjudPrayed) count++
        if (fajrPrayed) count++
        if (dhuhrPrayed) count++
        if (asrPrayed) count++
        if (maghribPrayed) count++
        if (ishaPrayed) count++
        return count
    }

    fun getFivePrayersCount(): Int {
        var count = 0
        if (fajrPrayed) count++
        if (dhuhrPrayed) count++
        if (asrPrayed) count++
        if (maghribPrayed) count++
        if (ishaPrayed) count++
        return count
    }

    fun getPoints(): Int {
        return getCompletedPrayersCount()
    }
}
