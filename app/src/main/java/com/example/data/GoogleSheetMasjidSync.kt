package com.example.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.Locale

object GoogleSheetMasjidSync {
    const val DEFAULT_SHEET_URL = "https://docs.google.com/spreadsheets/d/13l1dJh64fyOnpHFlw81iWKHZlA5ko0JVWJ_qoF43k0g/export?format=csv"
    const val SHEET_EDIT_URL = "https://docs.google.com/spreadsheets/d/13l1dJh64fyOnpHFlw81iWKHZlA5ko0JVWJ_qoF43k0g/edit?usp=sharing"
    const val DRIVE_FOLDER_URL = "https://drive.google.com/drive/folders/1zEbq9A1LvGk-etUfVcMHUhKd6bqVH01n?usp=sharing"

    val DEFAULT_CSV_CONTENT = """
Masjid Name,Mohammadiya Masjid,,,,,
Address,Swagat Nagar,,,,,
ID,100111111,,,,,
Masjid Photo,https://drive.google.com/file/d/1QP6elu7nlZwmrxjG4p-eyZWOrEaEdiwo/view?usp=drive_link,,,,,
,Fajr,Zohar,Asr,Maghrib,Isha,Jummah
Azan,05:40,01:15,05:17,06:10,07:50,12:30
Jammat,06:15,01:30,05:30,06:12,07:59,01:30
Admin ID,admin,,,,,
Password,9960171516,,,,,
,,,,,,
Masjid Name,Hajrat Imam Hussain Masjid,,,,,
Address,Tai Chowk,,,,,
ID,100111112,,,,,
Masjid Photo,https://drive.google.com/file/d/1Wtt9FYQSWz2o0PpxuCtGJZjSKBOLNhjH/view?usp=drive_link,,,,,
,Fajr,Zohar,Asr,Maghrib,Isha,Jummah
Azan,05:42,01:15,05:18,06:11,07:55,12:30
Jammat,06:17,01:30,05:32,06:13,08:05,01:30
Admin ID,admin,,,,,
Password,9970595659,,,,,
,,,,,,
Masjid Name,Abu Bakar Siddique Masjid,,,,,
Address,Mumtaz Nagar,,,,,
ID,100111113,,,,,
Masjid Photo,https://drive.google.com/file/d/1wtzGogJQgbTLR1rHlTAocBeMdwMESBtD/view?usp=drive_link,,,,,
,Fajr,Zohar,Asr,Maghrib,Isha,Jummah
Azan,05:42,01:15,05:18,06:11,07:55,12:30
Jammat,06:17,01:30,05:32,06:13,08:05,01:30
Admin ID,admin,,,,,
Password,9371883412,,,,,
,,,,,,
Masjid Name,Hazrat Jang Bahadur Salabat Kha,,,,,
Address,"Bhayya Chowk, Railway Station Ground",,,,,
ID,100111114,,,,,
Masjid Photo,https://drive.google.com/file/d/1Ju4p3KkS6sc3vzSvf68Bm1panplC_g8r/view?usp=drive_link,,,,,
,Fajr,Zohar,Asr,Maghrib,Isha,Jummah
Azan,05:42,01:15,05:18,06:11,07:55,12:30
Jammat,06:17,01:30,05:32,06:13,08:05,01:30
Admin ID,admin,,,,,
Password,9595996629,,,,,
""".trimIndent()

    fun extractGoogleDriveDirectUrl(rawUrl: String): String {
        val clean = rawUrl.trim()
        if (clean.isBlank()) return ""
        val idRegex = "(?:/file/d/|/d/|id=)([-_a-zA-Z0-9]{20,})".toRegex()
        val match = idRegex.find(clean)?.groupValues?.getOrNull(1)
        if (match != null) {
            return "https://lh3.googleusercontent.com/d/$match=w1000"
        }
        val fallbackRegex = "[-_a-zA-Z0-9]{25,}".toRegex()
        val fallbackMatch = fallbackRegex.findAll(clean).lastOrNull()?.value
        return if (fallbackMatch != null) {
            "https://lh3.googleusercontent.com/d/$fallbackMatch=w1000"
        } else {
            clean
        }
    }

    fun to24Hr(timeStr: String, isPm: Boolean): String {
        val clean = timeStr.trim()
        if (!clean.contains(":")) return clean
        val parts = clean.split(":")
        var h = parts[0].toIntOrNull() ?: return clean
        val m = parts[1].toIntOrNull() ?: return clean
        if (isPm) {
            if (h in 1..11) {
                h += 12
            }
        } else {
            if (h == 12) {
                h = 0
            }
        }
        return String.format(Locale.US, "%02d:%02d", h, m)
    }

    fun formatForCsv(time24: String?): String {
        if (time24.isNullOrBlank() || !time24.contains(":")) return "00:00"
        val parts = time24.trim().split(":")
        val rawH = parts[0].toIntOrNull() ?: 0
        val m = parts[1].toIntOrNull() ?: 0
        val h12 = when {
            rawH == 0 -> 12
            rawH > 12 -> rawH - 12
            else -> rawH
        }
        return String.format(Locale.US, "%02d:%02d", h12, m)
    }

    suspend fun fetchCsv(urlStr: String = DEFAULT_SHEET_URL): String = withContext(Dispatchers.IO) {
        val url = URL(urlStr)
        val conn = (url.openConnection() as HttpURLConnection).apply {
            requestMethod = "GET"
            connectTimeout = 8000
            readTimeout = 8000
            instanceFollowRedirects = true
        }
        BufferedReader(InputStreamReader(conn.inputStream)).use { reader ->
            reader.readText()
        }
    }

    fun buildCsv(masajid: List<MasjidItem>): String {
        val sb = StringBuilder()
        for (m in masajid) {
            sb.append("Masjid Name,${m.name},,,,,\n")
            sb.append("Address,${m.area},,,,,\n")
            sb.append("ID,${m.id},,,,,\n")
            val photoLink = if (m.photoUrl.isNotBlank()) m.photoUrl else ""
            sb.append("Masjid Photo,$photoLink,,,,,\n")
            sb.append(",Fajr,Zohar,Asr,Maghrib,Isha,Jummah\n")

            val fAzan = formatForCsv(m.fajrAzanFixed ?: "05:40")
            val zAzan = formatForCsv(m.zoharAzanFixed ?: "13:15")
            val aAzan = formatForCsv(m.asrAzanFixed ?: "17:17")
            val mAzan = formatForCsv(m.maghribAzanFixed ?: "18:10")
            val iAzan = formatForCsv(m.ishaAzanFixed ?: "19:50")
            val jAzan = formatForCsv(m.jumahAzanTime)
            sb.append("Azan,$fAzan,$zAzan,$aAzan,$mAzan,$iAzan,$jAzan\n")

            val fJammat = formatForCsv(m.fajrJammatFixed ?: "06:15")
            val zJammat = formatForCsv(m.zoharJammatFixed ?: "13:30")
            val aJammat = formatForCsv(m.asrJammatFixed ?: "17:30")
            val mJammat = formatForCsv(m.maghribJammatFixed ?: "18:12")
            val iJammat = formatForCsv(m.ishaJammatFixed ?: "19:59")
            val jJammat = formatForCsv(m.jumahJammatTime)
            sb.append("Jammat,$fJammat,$zJammat,$aJammat,$mJammat,$iJammat,$jJammat\n")
            val admId = if (m.adminId.isNotBlank()) m.adminId else "admin"
            sb.append("Admin ID,$admId,,,,,\n")
            sb.append("Password,${m.adminPassword},,,,,\n")
            sb.append(",,,,,,\n")
        }
        return sb.toString()
    }

    fun parseCsv(csvText: String): List<MasjidItem> {
        val lines = csvText.lines()
        val list = mutableListOf<MasjidItem>()

        var currentName = ""
        var currentAddress = ""
        var currentId = ""
        var currentPhoto = ""
        var currentAdminId = "admin"
        var currentPassword = ""
        var azanTimes = listOf<String>()
        var jammatTimes = listOf<String>()

        fun flushCurrent() {
            if (currentName.isNotBlank() && currentId.isNotBlank()) {
                // Azan: Fajr (AM), Zohar (PM), Asr (PM), Maghrib (PM), Isha (PM), Jummah (PM/12)
                val fAzan = azanTimes.getOrNull(0)?.let { to24Hr(it, false) } ?: "05:40"
                val zAzan = azanTimes.getOrNull(1)?.let { to24Hr(it, true) } ?: "13:15"
                val aAzan = azanTimes.getOrNull(2)?.let { to24Hr(it, true) } ?: "17:17"
                val mAzan = azanTimes.getOrNull(3)?.let { to24Hr(it, true) } ?: "18:10"
                val iAzan = azanTimes.getOrNull(4)?.let { to24Hr(it, true) } ?: "19:50"
                val jAzan = azanTimes.getOrNull(5)?.let { to24Hr(it, false) } ?: "12:30"

                // Jammat: Fajr (AM), Zohar (PM), Asr (PM), Maghrib (PM), Isha (PM), Jummah (PM)
                val fJammat = jammatTimes.getOrNull(0)?.let { to24Hr(it, false) } ?: "06:15"
                val zJammat = jammatTimes.getOrNull(1)?.let { to24Hr(it, true) } ?: "13:30"
                val aJammat = jammatTimes.getOrNull(2)?.let { to24Hr(it, true) } ?: "17:30"
                val mJammat = jammatTimes.getOrNull(3)?.let { to24Hr(it, true) } ?: "18:12"
                val iJammat = jammatTimes.getOrNull(4)?.let { to24Hr(it, true) } ?: "19:59"
                val jJammat = jammatTimes.getOrNull(5)?.let { to24Hr(it, true) } ?: "13:30"

                val directPhoto = extractGoogleDriveDirectUrl(currentPhoto)

                val masjidItem = MasjidItem(
                    id = currentId.trim(),
                    name = currentName.trim(),
                    area = currentAddress.trim(),
                    city = "Solapur",
                    state = "Maharashtra",
                    photoUrl = directPhoto,
                    jumahAzanTime = jAzan,
                    jumahJammatTime = jJammat,
                    fajrAzanFixed = fAzan,
                    fajrJammatFixed = fJammat,
                    zoharAzanFixed = zAzan,
                    zoharJammatFixed = zJammat,
                    asrAzanFixed = aAzan,
                    asrJammatFixed = aJammat,
                    maghribAzanFixed = mAzan,
                    maghribJammatFixed = mJammat,
                    ishaAzanFixed = iAzan,
                    ishaJammatFixed = iJammat,
                    adminId = currentAdminId.ifBlank { "admin" },
                    adminPassword = currentPassword
                )
                list.add(masjidItem)
            }
            currentName = ""
            currentAddress = ""
            currentId = ""
            currentPhoto = ""
            currentAdminId = "admin"
            currentPassword = ""
            azanTimes = emptyList()
            jammatTimes = emptyList()
        }

        for (rawLine in lines) {
            val line = rawLine.trim()
            if (line.isEmpty()) continue

            val tokens = line.split(",").map { it.trim() }
            if (tokens.isEmpty()) continue

            val first = tokens[0]
            if (first.equals("Masjid Name", ignoreCase = true)) {
                if (currentName.isNotBlank() && currentId.isNotBlank()) {
                    flushCurrent()
                }
                currentName = tokens.getOrElse(1) { "" }
            } else if (first.equals("Address", ignoreCase = true)) {
                currentAddress = tokens.getOrElse(1) { "" }
            } else if (first.equals("ID", ignoreCase = true)) {
                currentId = tokens.getOrElse(1) { "" }
            } else if (first.equals("Masjid Photo", ignoreCase = true)) {
                currentPhoto = tokens.getOrElse(1) { "" }
            } else if (first.equals("Azan", ignoreCase = true)) {
                azanTimes = tokens.drop(1).filter { it.isNotEmpty() }
            } else if (first.equals("Jammat", ignoreCase = true)) {
                jammatTimes = tokens.drop(1).filter { it.isNotEmpty() }
            } else if (first.equals("Admin ID", ignoreCase = true) || first.equals("AdminID", ignoreCase = true)) {
                currentAdminId = tokens.getOrElse(1) { "admin" }
            } else if (first.equals("Password", ignoreCase = true)) {
                currentPassword = tokens.getOrElse(1) { "" }
            }
        }
        flushCurrent()
        return list
    }
}
