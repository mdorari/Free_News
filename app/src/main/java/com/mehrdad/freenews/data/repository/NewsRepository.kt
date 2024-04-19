package com.mehrdad.freenews.data.repository

import com.mehrdad.freenews.data.model.remote.Article

interface NewsRepository {

    suspend fun getHeadlineForCountry(
        country: String,
        apiKey: String
    ): Result<List<Article>>

    suspend fun changeCounty(country: String)
}