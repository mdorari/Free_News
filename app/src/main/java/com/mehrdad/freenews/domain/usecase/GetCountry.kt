package com.mehrdad.freenews.domain.usecase

import com.mehrdad.freenews.data.model.Country
import com.mehrdad.freenews.data.repository.NewsRepository
import kotlinx.coroutines.flow.Flow


class GetCountry(
    private val newsRepository: NewsRepository
) {
//    operator fun invoke(): Flow<Country> {
//        return newsRepository.getCountry()
//    }
}