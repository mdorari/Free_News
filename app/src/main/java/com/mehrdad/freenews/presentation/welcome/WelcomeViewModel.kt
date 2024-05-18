package com.mehrdad.freenews.presentation.welcome

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehrdad.freenews.data.local.UserSettings
import com.mehrdad.freenews.data.repository.DataStoreRepository
import com.mehrdad.freenews.domain.usecase.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases,
    private val repository: DataStoreRepository
) : ViewModel() {

    var state by mutableStateOf(WelcomeState())
        private set


    fun saveOnBoardingState(completed: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveOnBoardingState(completed)
        }
    }



    init {
        viewModelScope.launch {
            newsUseCases.upsertUserSettings(UserSettings(1, "us"))
        }
    }


    fun onEvent(event: WelcomeEvent) {
        when (event) {
            is WelcomeEvent.UpdateSelectedCountry -> {
                viewModelScope.launch {
                    newsUseCases.upsertUserSettings(
                        UserSettings(
                            userId = 1,
                            selectedCountryInitial = event.selectedCountry.initials
                        )
                    )
                    state = state.copy(
                        selectedCountry = event.selectedCountry
                    )

                }
            }
        }
    }
}