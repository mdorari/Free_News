package com.mehrdad.freenews.presentation.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehrdad.freenews.data.remote.api.NewsApi.Companion.API_KEY
import com.mehrdad.freenews.data.remote.model.remote.Article
import com.mehrdad.freenews.data.remote.model.remote.Source
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
            val selectedCountryInitials =
                newsUseCases.readUserSettings(1).first().selectedCountryInitial
            val selectedCountry = newsUseCases.getCountryByInitials(selectedCountryInitials)
            state = state.copy(
                isRefreshing = true,
                articles = emptyList(),
                country = selectedCountry
            )
            newsUseCases
                .getNewsForCountry(
                    country = state.country.initials,
                    apiKey = API_KEY
                )
                .onSuccess { articles ->
                    val mappedArtilelist = articles.map { article ->
                        Article(
                            author = article.author,
                            content = article.content,
                            description = article.description,
                            publishedAt = article.publishedAt,
                            source = Source(
                                id = article.source.id ?: "unknown source",
                                name = article.source.name ?: "unknown source"
                            ),
                            title = article.title,
                            url = article.url,
                            urlToImage = article.urlToImage
                                ?: "https://demofree.sirv.com/nope-not-here.jpg?w=150"
                        )
                    }
                    Log.d("Mehrdad filtered articles", "getNews: $mappedArtilelist")
                    state = state.copy(
                        bannerNews = mappedArtilelist.first(),
                        articles = mappedArtilelist.drop(1),
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