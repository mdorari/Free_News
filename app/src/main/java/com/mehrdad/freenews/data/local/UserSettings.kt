package com.mehrdad.freenews.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserSettings(
    @PrimaryKey
    val userId:Int = 1,
    val selectedCountryInitial:String,
)
