package com.mehrdad.freenews.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "on_boarding_pref")

class DataStoreRepository(context: Context) {

    private object PreferenceKeys {
        val onBoardingKey = booleanPreferencesKey("on_boarding_completed")
        val hasNotificationPermission = booleanPreferencesKey("has_notification_permission")
    }

    private val dataStore = context.dataStore

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferenceKeys.onBoardingKey] = completed
        }
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val onBoardingState = preferences[PreferenceKeys.onBoardingKey] ?: false
                onBoardingState
            }
    }

    suspend fun saveNotificationPermissionState(hasNotificationPermission: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferenceKeys.hasNotificationPermission] = hasNotificationPermission
        }
    }

    fun readNotificationPermissionState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val hasNotificationPermission =
                    preferences[PreferenceKeys.hasNotificationPermission] ?: false
                hasNotificationPermission
            }
    }
}