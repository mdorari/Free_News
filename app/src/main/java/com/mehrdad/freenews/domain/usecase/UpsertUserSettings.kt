package com.mehrdad.freenews.domain.usecase

import com.mehrdad.freenews.data.local.UserSettings
import com.mehrdad.freenews.data.repository.NewsRepository

class UpsertUserSettings(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(userSettings: UserSettings) {
        return newsRepository.upsertUserSettings(userSettings)
    }
}