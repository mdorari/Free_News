package com.mehrdad.freenews.presentation.home

import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehrdad.freenews.data.api.NewsApi.Companion.API_KEY
import com.mehrdad.freenews.domain.usecase.NewsUseCases
import com.mehrdad.freenews.presentation.UiEvent
import com.mehrdad.freenews.presentation.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set


    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        getNews()
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnRefresh -> {
                getNews()
            }

            is HomeEvent.OnNewsClick -> {
//                state = state.copy
            }
        }
    }

    private fun getNews() {
        viewModelScope.launch {
            state = state.copy(
                isRefreshing = true,
                articles = emptyList()
            )
            newsUseCases
                .getNewsForCountry(
                    country = state.country,
                    apiKey = API_KEY
                )
                .onSuccess { articles ->
                    val filteredArticles = articles.filter { article ->
                        article.source.id != null
                        article.urlToImage != null
                    }
                    state = state.copy(
                        bannerNews = filteredArticles.first(),
                        articles = filteredArticles.drop(1),
                        isRefreshing = false
                    )
                }
                .onFailure {
                    state = state.copy(isRefreshing = false)
                    _uiEvent.send(
                        UiEvent
                            .showSnackBar(
                                message = UiText
                                    .DynamicString(
                                        "Please try again"
                                    )
                            )
                    )
                }
        }
    }
}