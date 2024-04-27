package com.mehrdad.freenews.domain.usecase

import androidx.datastore.preferences.core.Preferences
import com.mehrdad.freenews.data.model.Country
import com.mehrdad.freenews.data.repository.NewsRepository

class SetCountry(
    private val newsRepository: NewsRepository
) {
//    suspend operator fun invoke(country: Country): Preferences {
//        return newsRepository.setCounty(country)
//    }
}