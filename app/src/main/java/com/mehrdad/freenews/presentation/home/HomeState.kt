package com.mehrdad.freenews.presentation.home

import com.mehrdad.freenews.data.model.Article

data class HomeState (
    val country : String = "us",
    val isRefreshing:Boolean = false,
    val articles:List<Article> = emptyList()
)