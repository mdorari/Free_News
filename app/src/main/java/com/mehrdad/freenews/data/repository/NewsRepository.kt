package com.mehrdad.freenews.data.repository

import androidx.datastore.preferences.core.Preferences
import com.mehrdad.freenews.data.model.Country
import com.mehrdad.freenews.data.model.remote.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getHeadlineForCountry(
        country: String,
        apiKey: String
    ): Result<List<Article>>

//    suspend fun setCounty(country: Country) : Preferences
//
//    fun getCountry(): Flow<Country>
}