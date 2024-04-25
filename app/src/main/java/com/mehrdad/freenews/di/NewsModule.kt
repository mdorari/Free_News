package com.mehrdad.freenews.di

import android.app.Application
import com.mehrdad.freenews.data.api.NewsApi
import com.mehrdad.freenews.data.repository.NewsRepository
import com.mehrdad.freenews.data.repository.NewsRepositoryImpl
import com.mehrdad.freenews.domain.usecase.GetNewsForCountry
import com.mehrdad.freenews.domain.usecase.NewsUseCases
import com.mehrdad.freenews.domain.usecase.SelectCountry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
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

//    @PrimaryKey
//    @Singleton
//    fun provideNewsDatabase(app: Application): NewsDatabase {
//        return Room.databaseBuilder(
//            app,
//            NewsDatabase::class.java,
//            "news_db"
//        ).build()
//    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        api: NewsApi,
        application: Application
//        db:NewsDatabase
    ): NewsRepository {
        return NewsRepositoryImpl(
//            dao = db.dao,
            api = api,
            context = application
        )
    }

    @Provides
    @Singleton
    fun provideNewsUseCases(
        repository: NewsRepository
    ):NewsUseCases{
        return NewsUseCases(
            getNewsForCountry = GetNewsForCountry(repository),
            selectCountry = SelectCountry(repository)
        )
    }
}