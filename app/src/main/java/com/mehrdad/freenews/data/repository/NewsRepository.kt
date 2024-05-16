package com.mehrdad.freenews.data.repository

import com.mehrdad.freenews.data.local.UserSettings
import com.mehrdad.freenews.data.remote.model.Country
import com.mehrdad.freenews.data.remote.model.remote.Article

interface NewsRepository {

    suspend fun getHeadlineForCountry(
        country: String,
        apiKey: String
    ): Result<List<Article>>

    suspend fun getHeadlinesForCountryAndCategory(
        country: String,
        apiKey: String,
        category: String
    ): Result<List<Article>>

    suspend fun upsertUserSettings(userSettings: UserSettings)

    suspend fun readUserSettings(userId: Int): List<UserSettings>

    suspend fun getCountryByInitials(initials: String): Country

}