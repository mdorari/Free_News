package com.mehrdad.freenews.data.remote.model

import androidx.room.PrimaryKey


data class Country(
    val name: String,
//    @PrimaryKey(autoGenerate = false)
    val initials: String
)