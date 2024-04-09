package com.mehrdad.freenews.data.repository

import com.mehrdad.freenews.data.api.NewsApi
import com.mehrdad.freenews.data.model.Article
import com.mehrdad.freenews.data.model.Headlines
import java.lang.Exception

class NewsRepositoryImpl(
//    private val dao:NewsDao,
    private val api: NewsApi
):NewsRepository {
    override suspend fun getHeadlineForCountry(
        country: String,
        apiKey: String)
    : Result<List<Article>> {
        return try {
            val newsDto = api.getHeadlinesForCountry(
                country = country,
                apiKey = apiKey
            )
            Result.success(
                newsDto.articles
            )
        } catch (e:Exception){
            e.printStackTrace()
            Result.failure(e)
        }
    }
}