package com.mehrdad.freenews.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert



@Dao
interface NewsDao {

    @Upsert
    suspend fun upsertUserSettings(userSettings:UserSettings)

    @Query("SELECT * FROM UserSettings WHERE userId = :userId")
    suspend fun getUserSettings(userId:Int): List<UserSettings>

//    @Query("SELECT * FROM Country WHERE initials = :countryInitials")
//    suspend fun getCountryByCountryInitials(countryInitials:String):Country

//    @Query("SELECT * FROM Country")
//    fun getCountries():List<Country>
}