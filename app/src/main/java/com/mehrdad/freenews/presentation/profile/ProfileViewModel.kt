package com.mehrdad.freenews.presentation.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehrdad.freenews.domain.usecase.NewsUseCases
import com.mehrdad.freenews.presentation.home.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : ViewModel() {

    var state by mutableStateOf(ProfileState())
        private set

    fun onEvent(event: ProfileEvent) {
        when (event) {
            is ProfileEvent.UpdateSelectedCountry -> {
                viewModelScope.launch{
                    state = state.copy(
                        selectedCountry = event.selectedCountry
                    )
                    newsUseCases.selectCountry(
                        country = event.selectedCountry
                    )
                }

            }
        }
    }
}