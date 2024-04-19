package com.mehrdad.freenews.presentation.home

import com.mehrdad.freenews.data.model.remote.Article

sealed class HomeEvent {
    object OnRefresh : HomeEvent()
    data class OnNewsClick(val article: Article):HomeEvent()
//    data class onFilterClick(val )
}