package com.example.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "azan_prefs")

class PreferencesRepository(private val context: Context) {

    private val KEY_LANGUAGE = stringPreferencesKey("language")
    private val KEY_RESTORED_TAQWA_POINTS = androidx.datastore.preferences.core.intPreferencesKey("restored_taqwa_points")

    val languageFlow: Flow<String> = context.dataStore.data.map { prefs ->
        prefs[KEY_LANGUAGE] ?: "en"
    }

    val restoredTaqwaPointsFlow: Flow<Int> = context.dataStore.data.map { prefs ->
        prefs[KEY_RESTORED_TAQWA_POINTS] ?: 0
    }

    suspend fun setRestoredTaqwaPoints(points: Int) {
        context.dataStore.edit { prefs ->
            prefs[KEY_RESTORED_TAQWA_POINTS] = points
        }
    }

    suspend fun setLanguage(lang: String) {
        context.dataStore.edit { prefs ->
            prefs[KEY_LANGUAGE] = lang
        }
    }

    fun isAzanEnabled(name: String): Flow<Boolean> {
        val key = booleanPreferencesKey("azan_enabled_${name.lowercase()}")
        return context.dataStore.data.map { prefs ->
            prefs[key] ?: true
        }
    }

    suspend fun setAzanToggle(name: String, enabled: Boolean) {
        val key = booleanPreferencesKey("azan_enabled_${name.lowercase()}")
        context.dataStore.edit { prefs ->
            prefs[key] = enabled
        }
    }

    fun getCustomJammatTime(name: String): Flow<String?> {
        val key = stringPreferencesKey("jammat_time_${name.lowercase()}")
        return context.dataStore.data.map { prefs ->
            prefs[key]
        }
    }

    suspend fun setCustomJammatTime(name: String, time24: String) {
        val key = stringPreferencesKey("jammat_time_${name.lowercase()}")
        context.dataStore.edit { prefs ->
            prefs[key] = time24
        }
    }

    fun getCustomJumahAzan(): Flow<String?> {
        val key = stringPreferencesKey("azan_time_jumah")
        return context.dataStore.data.map { prefs ->
            prefs[key]
        }
    }

    suspend fun setCustomJumahAzan(time24: String) {
        val key = stringPreferencesKey("azan_time_jumah")
        context.dataStore.edit { prefs ->
            prefs[key] = time24
        }
    }

    fun getAllCustomJammatTimes(): Flow<Map<String, String>> {
        return context.dataStore.data.map { prefs ->
            val map = mutableMapOf<String, String>()
            listOf("fajr", "dhuhr", "jumah", "asr", "maghrib", "isha").forEach { prayer ->
                val key = stringPreferencesKey("jammat_time_$prayer")
                prefs[key]?.let { if (it.isNotEmpty()) map[prayer] = it }
            }
            map
        }
    }

    val selectedMasjidIdFlow: Flow<String> = context.dataStore.data.map { prefs ->
        prefs[stringPreferencesKey("selected_masjid_id")] ?: "delhi_jama_masjid"
    }

    suspend fun setSelectedMasjidId(masjidId: String) {
        context.dataStore.edit { prefs ->
            prefs[stringPreferencesKey("selected_masjid_id")] = masjidId
        }
    }
}
