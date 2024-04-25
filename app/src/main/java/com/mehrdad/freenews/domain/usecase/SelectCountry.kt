package com.mehrdad.freenews.domain.usecase

import com.mehrdad.freenews.data.model.Country
import com.mehrdad.freenews.data.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectCountry(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(country: Country): Flow<String> {
        return newsRepository.changeCounty(country)
    }
}