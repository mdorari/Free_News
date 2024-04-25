package com.mehrdad.freenews.data.repository

import com.mehrdad.freenews.data.model.Country
import com.mehrdad.freenews.data.model.remote.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getHeadlineForCountry(
        country: String,
        apiKey: String
    ): Result<List<Article>>

    fun changeCounty(country: Country): Flow<String>
}