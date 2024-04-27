package com.mehrdad.freenews.presentation.home

import com.mehrdad.freenews.data.model.Country
import com.mehrdad.freenews.data.model.remote.Article
import com.mehrdad.freenews.data.model.remote.Source

data class HomeState (
    val country : Country = Country(name = "USA", initials = "us"),
    val isRefreshing:Boolean = false,
    val bannerNews: Article = Article(
        "",
        "",
        "",
        "",
        Source("",""),
        "",
        "",
        ""),
    val articles:List<Article> = emptyList()
)