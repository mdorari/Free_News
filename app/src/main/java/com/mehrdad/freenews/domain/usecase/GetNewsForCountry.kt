package com.mehrdad.freenews.domain.usecase

import com.mehrdad.freenews.data.model.remote.Article
import com.mehrdad.freenews.data.repository.NewsRepository

class GetNewsForCountry(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(
        country: String,
        apiKey: String
    ): Result<List<Article>> {
        if (country.isBlank()) {
            return Result.success(emptyList())
        }
        return repository.getHeadlineForCountry(
            country = country,
            apiKey = apiKey
        )
    }
}