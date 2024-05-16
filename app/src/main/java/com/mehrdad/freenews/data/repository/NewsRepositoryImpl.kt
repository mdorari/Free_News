package com.mehrdad.freenews.data.repository

import com.mehrdad.freenews.data.local.NewsDao
import com.mehrdad.freenews.data.local.UserSettings
import com.mehrdad.freenews.data.local.defaultCountries
import com.mehrdad.freenews.data.remote.api.NewsApi
import com.mehrdad.freenews.data.remote.model.Country
import com.mehrdad.freenews.data.remote.model.remote.Article
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val dao: NewsDao,
    private val api: NewsApi,
//    private val context: Context
) : NewsRepository {
    override suspend fun getHeadlineForCountry(
        country: String,
        apiKey: String
    )
            : Result<List<Article>> {
        return try {
            val newsDto = api.getHeadlinesForCountry(
                country = country,
                apiKey = apiKey
            )
            Result.success(
                newsDto.articles
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun upsertUserSettings(userSettings: UserSettings) {
        dao.upsertUserSettings(userSettings)
    }

    override suspend fun readUserSettings(userId:Int): List<UserSettings> {
        return dao.getUserSettings(userId = userId)
    }

    override suspend fun getCountryByInitials(initials: String): Country {
        return defaultCountries.first { it.initials == initials }
    }

//    override fun getCountries(): List<Country> {
//        return dao.getCountries()
//    }

//    override suspend fun setCounty(country: Country): Preferences {
//        return context.dataStore.edit { preferences ->
//            preferences[PreferencesKeys.COUNTRY_NAME] = country
//        }
//    }
//
//    override fun getCountry(): Flow<Country> {
//        return context.dataStore.data.map { preferences ->
//            preferences[PreferencesKeys.COUNTRY_NAME] ?: "us"
//        }
//    }

}

//private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)
//
//private object PreferencesKeys {
//    val COUNTRY_NAME = stringPreferencesKey(name = Constants.COUNTRY_NAME)
//}