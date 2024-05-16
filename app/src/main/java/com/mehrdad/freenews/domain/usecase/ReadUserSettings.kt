package com.mehrdad.freenews.domain.usecase

import com.mehrdad.freenews.data.local.UserSettings
import com.mehrdad.freenews.data.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class ReadUserSettings(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(
        userId: Int
    ): List<UserSettings> {
        return newsRepository.readUserSettings(userId)
    }
}