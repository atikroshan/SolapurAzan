package com.example.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "azan_timings")
data class AzanTiming(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val month: Int,
    val day: Int,
    val fajr: String,
    val dhuhr: String,
    val asr: String,
    val maghrib: String,
    val isha: String
)

@JsonClass(generateAdapter = true)
data class RawAzanResponse(
    val jan: List<RawAzanDay>?,
    val feb: List<RawAzanDay>?,
    val mar: List<RawAzanDay>?,
    val april: List<RawAzanDay>?,
    val may: List<RawAzanDay>?,
    val june: List<RawAzanDay>?,
    val july: List<RawAzanDay>?,
    val aug: List<RawAzanDay>?,
    val sep: List<RawAzanDay>?,
    val oct: List<RawAzanDay>?,
    val nov: List<RawAzanDay>?,
    val dec: List<RawAzanDay>?
)

@JsonClass(generateAdapter = true)
data class RawAzanDay(
    @Json(name = "Date") val date: String,
    @Json(name = "Fajar") val fajar: String,
    val zohar: String,
    val asr: String,
    val magrib: String,
    val isha: String
)
