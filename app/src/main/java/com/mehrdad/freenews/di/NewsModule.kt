package com.mehrdad.freenews.di

import android.app.Application
import androidx.room.Room
import com.mehrdad.freenews.data.local.NewsDao
import com.mehrdad.freenews.data.local.NewsDatabase
import com.mehrdad.freenews.data.remote.api.NewsApi
import com.mehrdad.freenews.data.repository.NewsRepository
import com.mehrdad.freenews.data.repository.NewsRepositoryImpl
import com.mehrdad.freenews.domain.usecase.GetCountryByInitials
import com.mehrdad.freenews.domain.usecase.GetNewsForCountry
import com.mehrdad.freenews.domain.usecase.NewsUseCases
import com.mehrdad.freenews.domain.usecase.ReadUserSettings
import com.mehrdad.freenews.domain.usecase.UpsertUserSettings
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }


    @Provides
    @Singleton
    fun provideNewsApi(client: OkHttpClient): NewsApi {
        return Retrofit.Builder()
            .baseUrl(NewsApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(app: Application): NewsDatabase {
        return Room.databaseBuilder(
            context = app,
            klass = NewsDatabase::class.java,
            name = "news_db"
        ).build()
//        .createFromAsset("database/userSettingsDB.db")
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao

    @Provides
    @Singleton
    fun provideNewsRepository(
        api: NewsApi,
        db: NewsDatabase
    ): NewsRepository {
        return NewsRepositoryImpl(
            dao = db.newsDao,
            api = api
        )
    }

    @Provides
    @Singleton
    fun provideNewsUseCases(
        repository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNewsForCountry = GetNewsForCountry(repository),
            readUserSettings = ReadUserSettings(repository),
            upsertUserSettings = UpsertUserSettings(repository),
            getCountryByInitials = GetCountryByInitials(repository)
//            setCountry = SetCountry(repository),
//            getCountry = GetCountry(repository)
        )
    }
}