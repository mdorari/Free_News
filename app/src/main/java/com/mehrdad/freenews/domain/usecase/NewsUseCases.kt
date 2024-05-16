package com.mehrdad.freenews.domain.usecase

data class NewsUseCases(
    val getNewsForCountry: GetNewsForCountry,
    val readUserSettings: ReadUserSettings,
    val upsertUserSettings:UpsertUserSettings,
    val getCountryByInitials: GetCountryByInitials
)
