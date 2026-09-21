package com.example.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class PreferencesRepository(private val context: Context) {
    
    companion object {
        val LANGUAGE = stringPreferencesKey("language")
        // Toggles
        val TOGGLE_FAJR = booleanPreferencesKey("toggle_fajr")
        val TOGGLE_DHUHR = booleanPreferencesKey("toggle_dhuhr")
        val TOGGLE_ASR = booleanPreferencesKey("toggle_asr")
        val TOGGLE_MAGHRIB = booleanPreferencesKey("toggle_maghrib")
        val TOGGLE_ISHA = booleanPreferencesKey("toggle_isha")
    }

    val languageFlow: Flow<String> = context.dataStore.data.map { it[LANGUAGE] ?: "en" }
    
    fun isAzanEnabled(name: String): Flow<Boolean> {
        val key = booleanPreferencesKey("toggle_${name.lowercase()}")
        return context.dataStore.data.map { it[key] ?: true }
    }

    suspend fun setLanguage(lang: String) {
        context.dataStore.edit { it[LANGUAGE] = lang }
    }

    suspend fun setAzanToggle(name: String, enabled: Boolean) {
        val key = booleanPreferencesKey("toggle_${name.lowercase()}")
        context.dataStore.edit { it[key] = enabled }
    }
}
