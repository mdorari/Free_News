package com.mehrdad.freenews.domain.usecase

import androidx.datastore.preferences.core.Preferences
import com.mehrdad.freenews.data.local.UserSettings
import com.mehrdad.freenews.data.remote.model.Country
import com.mehrdad.freenews.data.repository.NewsRepository

class UpsertUserSettings(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(userSettings: UserSettings) {
        return newsRepository.upsertUserSettings(userSettings)
    }
}