package com.mehrdad.freenews.data.repository

import com.mehrdad.freenews.data.model.Article
import com.mehrdad.freenews.data.model.Headlines

interface NewsRepository {

    suspend fun getHeadlineForCountry(
        country: String,
        apiKey: String
    ): Result<List<Article>>
}