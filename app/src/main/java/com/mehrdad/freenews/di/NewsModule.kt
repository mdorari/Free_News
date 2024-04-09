package com.mehrdad.freenews.di

import com.mehrdad.freenews.data.api.NewsApi
import com.mehrdad.freenews.data.repository.NewsRepository
import com.mehrdad.freenews.data.repository.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
            .create()
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
//        db:NewsDatabase
    ): NewsRepository {
        return NewsRepositoryImpl(
//            dao = db.dao,
            api = api
        )
    }
}