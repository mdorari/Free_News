package com.mehrdad.freenews.presentation.home

import com.mehrdad.freenews.data.remote.model.Filter
import com.mehrdad.freenews.data.remote.model.remote.Article

sealed class HomeEvent {
    object OnRefresh : HomeEvent()
    data class OnNewsClick(val article: Article):HomeEvent()
    data class OnFilterClick(val filter: Filter):HomeEvent()
}