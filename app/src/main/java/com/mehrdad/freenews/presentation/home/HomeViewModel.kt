package com.mehrdad.freenews.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehrdad.freenews.data.remote.api.NewsApi.Companion.API_KEY
import com.mehrdad.freenews.data.remote.model.Filter
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
        getNewsForCategory(state.selectedFilter.text)
    }


    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnRefresh -> {
                getNews()
                getNewsForCategory(state.selectedFilter.text)
            }

            is HomeEvent.OnNewsClick -> {
//                state = state.copy
            }

            is HomeEvent.OnFilterClick -> {
                val newList = moveItemToBeginning(state.filterList, event.filter)
                state = state.copy(
                    selectedFilter = event.filter,
                    filterList = newList
                )
                getNewsForCategory(state.selectedFilter.text)
            }
        }
    }

    private fun moveItemToBeginning(list: List<Filter>, item: Filter): List<Filter> {
        val mutableList = list.toMutableList()
        val index = mutableList.indexOf(item)
        if (index != -1) {
            mutableList.removeAt(index)
            mutableList.add(0, item)
        }
        return mutableList.toList()
    }

    private fun getNewsForCategory(newsCategory: String) {
        viewModelScope.launch {
            val selectedCountryInitials =
                newsUseCases.readUserSettings(1).first().selectedCountryInitial
            val selectedCountry = newsUseCases.getCountryByInitials(selectedCountryInitials)
            state = state.copy(
                isRefreshing = true,
                articlesByCategory = emptyList(),
                country = selectedCountry
            )
            newsUseCases
                .getNewsForCountryByCategory(
                    country = state.country.initials,
                    apiKey = API_KEY,
                    category = newsCategory
                )
                .onSuccess { articles ->
                    val mappedArticle = articles.map { article ->
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
                    state = state.copy(
                        bannerNews = mappedArticle.first(),
                        articlesByCategory = mappedArticle.drop(1),
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
                    val mappedArticle = articles.map { article ->
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
                    state = state.copy(
                        articles = mappedArticle.drop(1),
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