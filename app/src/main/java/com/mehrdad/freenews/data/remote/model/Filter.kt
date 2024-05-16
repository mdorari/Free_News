package com.mehrdad.freenews.data.remote.model

data class Filter(
    val text: String,
)

val defaultFilterList: List<Filter> = listOf(
    Filter("business"),
    Filter("entertainment"),
    Filter("health"),
    Filter("science"),
    Filter("sports"),
    Filter("technology")
)
