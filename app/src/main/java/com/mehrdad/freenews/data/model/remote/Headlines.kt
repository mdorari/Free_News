package com.mehrdad.freenews.data.model.remote

data class Headlines(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)