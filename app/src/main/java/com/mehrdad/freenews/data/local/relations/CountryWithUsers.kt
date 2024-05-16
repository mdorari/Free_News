package com.mehrdad.freenews.data.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.mehrdad.freenews.data.local.UserSettings
import com.mehrdad.freenews.data.remote.model.Country

data class CountryWithUsers(
    @Embedded val country: Country,
    @Relation(
        parentColumn = "initials",
        entityColumn = "selectedCountryInitial"
    )
    val users:List<UserSettings>
)
