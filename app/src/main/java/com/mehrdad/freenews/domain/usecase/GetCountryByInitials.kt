package com.mehrdad.freenews.domain.usecase

import com.mehrdad.freenews.data.remote.model.Country
import com.mehrdad.freenews.data.repository.NewsRepository

class GetCountryByInitials(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(
        initials: String
    ):Country{
        return repository.getCountryByInitials(initials = initials)
    }
}