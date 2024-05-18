package com.mehrdad.freenews.presentation.welcome

import com.mehrdad.freenews.data.local.defaultCountries
import com.mehrdad.freenews.data.remote.model.Country

data class WelcomeState(
    val countries: List<Country> = defaultCountries,
    val selectedCountry: Country = Country(name = "USA", initials = "us"),
    val selectedCountryIndex: Int = 0
)

