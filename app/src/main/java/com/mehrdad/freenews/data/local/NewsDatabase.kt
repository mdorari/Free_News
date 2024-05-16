package com.mehrdad.freenews.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserSettings::class], version = 1, exportSchema = true)
abstract class NewsDatabase:RoomDatabase() {
    abstract val newsDao:NewsDao
}