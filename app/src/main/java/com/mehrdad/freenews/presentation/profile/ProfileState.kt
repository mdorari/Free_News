package com.mehrdad.freenews.presentation.profile

import com.mehrdad.freenews.data.local.defaultCountries
import com.mehrdad.freenews.data.remote.model.Country

data class ProfileState(
    val countries: List<Country> = defaultCountries,
    val selectedCountry: Country = Country(name = "USA", initials = "us"),
    val selectedCountryIndex:Int = 0
)

