package com.mehrdad.freenews.data.api

import com.mehrdad.freenews.BuildConfig
import com.mehrdad.freenews.data.model.remote.Headlines
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("/v2/top-headlines")
    suspend fun getHeadlinesForCountry(
        @Query("country") country:String,
        @Query("apiKey") apiKey:String = API_KEY
    ): Headlines

    @GET("/v2/top-headlines")
    suspend fun getHeadlinesForCountryAndCategory(
        @Query("country") country:String,
        @Query("category") category:String,
        @Query("apiKey") apiKey:String = API_KEY
    ): Headlines

    @GET("/v2/top-headlines")
    suspend fun getHeadlinesFromSource(
        @Query("sources") sources:String,
        @Query("apiKey") apiKey:String = API_KEY
    ): Headlines

    @GET("/v2/top-headlines")
    suspend fun searchInHeadlines(
        @Query("q") searchFor:String,
        @Query("apiKey") apiKey:String = API_KEY
    ): Headlines

    companion object{
        const val BASE_URL = "https://newsapi.org"
        const val API_KEY = BuildConfig.NEWS_API_KEY
    }
}