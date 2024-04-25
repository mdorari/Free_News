package com.mehrdad.freenews.presentation.profile

import com.mehrdad.freenews.data.model.Country

sealed class ProfileEvent {
    data class UpdateSelectedCountry(val selectedCountry: Country) : ProfileEvent()
}