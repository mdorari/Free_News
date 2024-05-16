package com.mehrdad.freenews.presentation.home

import com.mehrdad.freenews.data.remote.model.Country
import com.mehrdad.freenews.data.remote.model.Filter
import com.mehrdad.freenews.data.remote.model.defaultFilterList
import com.mehrdad.freenews.data.remote.model.remote.Article
import com.mehrdad.freenews.data.remote.model.remote.Source

data class HomeState(
    val country: Country = Country(name = "USA", initials = "us"),
    val isRefreshing: Boolean = false,
    val bannerNews: Article = Article(
        "",
        "",
        "",
        "",
        Source("", ""),
        "",
        "",
        ""
    ),
    val articles: List<Article> = emptyList(),
    val articlesByCategory:List<Article> = emptyList(),
    val filterList: List<Filter> = defaultFilterList,
    val selectedFilter: Filter = Filter("business")
)