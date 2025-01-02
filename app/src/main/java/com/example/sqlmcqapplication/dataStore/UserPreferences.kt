package com.example.sqlmcqapplication.dataStore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferences(private val context: Context) {
    companion object{
        val IS_FIRST_TIME = booleanPreferencesKey("is_first_time")
    }

    suspend fun saveFirstTime(value: Boolean){
        context.dataStore.edit {preferences ->
            preferences[IS_FIRST_TIME] = value
        }
    }

    val isFirstTime: Flow<Boolean> = context.dataStore.data
        .map {preferences ->
            preferences[IS_FIRST_TIME]!!
    }
}