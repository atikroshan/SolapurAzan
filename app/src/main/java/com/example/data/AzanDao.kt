package com.example.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AzanDao {
    @Query("SELECT * FROM azan_timings WHERE month = :month AND day = :day LIMIT 1")
    fun getTimingsForDate(month: Int, day: Int): Flow<AzanTiming?>

    @Query("SELECT * FROM azan_timings WHERE month = :month AND day = :day LIMIT 1")
    suspend fun getTimingsForDateSync(month: Int, day: Int): AzanTiming?

    @Query("SELECT COUNT(*) FROM azan_timings")
    suspend fun getCount(): Int

    @Query("DELETE FROM azan_timings")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(timings: List<AzanTiming>)
}
