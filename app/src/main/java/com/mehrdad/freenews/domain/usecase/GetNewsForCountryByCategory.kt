package com.mehrdad.freenews.domain.usecase

import com.mehrdad.freenews.data.remote.model.remote.Article
import com.mehrdad.freenews.data.repository.NewsRepository

class GetNewsForCountryByCategory(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(
        country: String,
        apiKey:String,
        category:String
    ):Result<List<Article>>{
        if (country.isBlank()) {
            return Result.success(emptyList())
        }
        return repository.getHeadlinesForCountryAndCategory(
            country = country,
            apiKey = apiKey,
            category = category
        )
    }
}