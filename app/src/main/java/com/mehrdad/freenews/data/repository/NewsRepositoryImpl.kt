package com.mehrdad.freenews.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.mehrdad.freenews.data.api.NewsApi
import com.mehrdad.freenews.data.model.Country
import com.mehrdad.freenews.data.model.remote.Article
import com.mehrdad.freenews.util.Constants
import com.mehrdad.freenews.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.lang.Exception

class NewsRepositoryImpl(
//    private val dao:NewsDao,
    private val api: NewsApi,
    private val context: Context
):NewsRepository {
    override suspend fun getHeadlineForCountry(
        country: String,
        apiKey: String)
    : Result<List<Article>> {
        return try {
            val newsDto = api.getHeadlinesForCountry(
                country = country,
                apiKey = apiKey
            )
            Result.success(
                newsDto.articles
            )
        } catch (e:Exception){
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override  fun changeCounty(country: Country): Flow<String> {
        return context.dataStore.data.map { preferences->
            preferences[PreferencesKeys.COUNTRY_NAME] ?: "us"
        }
    }

}

private val Context.dataStore:DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

private object PreferencesKeys{
    val COUNTRY_NAME = stringPreferencesKey(name = Constants.COUNTRY_NAME)
}