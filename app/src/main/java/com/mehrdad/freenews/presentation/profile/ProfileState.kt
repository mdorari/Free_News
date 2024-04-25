package com.mehrdad.freenews.presentation.profile

import com.mehrdad.freenews.data.model.Country

data class ProfileState(
    val selectedCountry: Country = Country.listOfCountries[0]
)
