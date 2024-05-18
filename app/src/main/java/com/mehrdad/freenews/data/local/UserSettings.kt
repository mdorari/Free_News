package com.mehrdad.freenews.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserSettings(
    @PrimaryKey
    @ColumnInfo(name = "userId", defaultValue = "1")
    val userId:Int = 1,
    @ColumnInfo(name = "selectedCountryInitial", defaultValue = "us")
    val selectedCountryInitial:String,
)
