package com.mehrdad.freenews.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mehrdad.freenews.data.remote.model.Country

@Entity
data class UserSettings(
    @PrimaryKey
    val userId:Int = 1,
    val selectedCountryInitial:String,
)
