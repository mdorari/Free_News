package com.mehrdad.freenews.presentation.profile

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehrdad.freenews.data.local.UserSettings
import com.mehrdad.freenews.data.local.defaultCountries
import com.mehrdad.freenews.data.repository.NewsRepository
import com.mehrdad.freenews.domain.usecase.NewsUseCases
import com.mehrdad.freenews.presentation.UiEvent
import com.mehrdad.freenews.presentation.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases,
    private val repository: NewsRepository
) : ViewModel() {

    var state by mutableStateOf(ProfileState())
        private set

//    private var countries = repository.getCountries()

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        getUserCountry()
    }

    private fun getUserCountry() {
        viewModelScope.launch {
            val selectedCountryInitials =
                newsUseCases.readUserSettings(1).first().selectedCountryInitial
            val selectedCountry = newsUseCases.getCountryByInitials(selectedCountryInitials)
            val selectedCountryIndex = defaultCountries.indexOf(selectedCountry)
            state = state.copy(
                selectedCountry = selectedCountry,
                selectedCountryIndex = selectedCountryIndex
            )

        }
    }

    fun onEvent(event: ProfileEvent) {
        when (event) {
            is ProfileEvent.UpdateSelectedCountry -> {
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
                    Log.d("Mehrdad select country", "onEvent: ${event.selectedCountry}")
//                    _uiEvent.send(
//                        UiEvent
//                            .showSnackBar(
//                                message = UiText
//                                    .DynamicString(
//                                        event.selectedCountry.name
//                                    )
//                            )
//                    )
                }
            }
        }
    }
}