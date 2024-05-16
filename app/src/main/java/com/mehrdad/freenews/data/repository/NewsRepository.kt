package com.mehrdad.freenews.data.repository

import androidx.datastore.preferences.core.Preferences
import com.mehrdad.freenews.data.local.UserSettings
import com.mehrdad.freenews.data.remote.model.Country
import com.mehrdad.freenews.data.remote.model.remote.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getHeadlineForCountry(
        country: String,
        apiKey: String
    ): Result<List<Article>>

    suspend fun upsertUserSettings(userSettings: UserSettings)

    suspend fun readUserSettings(userId:Int):List<UserSettings>

    suspend fun getCountryByInitials(initials:String):Country

//    fun getCountries():List<Country>
//    suspend fun setCounty(country: Country) : Preferences
//
//    fun getCountry(): Flow<Country>
}