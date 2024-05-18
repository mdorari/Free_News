package com.mehrdad.freenews.presentation.welcome

import com.mehrdad.freenews.data.remote.model.Country

sealed class WelcomeEvent {
    data class UpdateSelectedCountry(val selectedCountry: Country) : WelcomeEvent()
}