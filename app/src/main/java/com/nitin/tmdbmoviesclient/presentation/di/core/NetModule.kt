package com.nitin.tmdbmoviesclient.presentation.di.core

import com.nitin.tmdbmoviesclient.data.api.TMDBService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class NetModule(private val baseUrl : String) {

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient) : Retrofit{
        return Retrofit.Builder().
                addConverterFactory(GsonConverterFactory.create()).
                client(okHttpClient).
                baseUrl(baseUrl).
                build()
    }

    @Singleton
    @Provides
    fun providesHHTPClient(interceptor : HttpLoggingInterceptor): OkHttpClient {
        val client = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
        }.build()
        return client
    }

    @Singleton
    @Provides
    fun provideInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        return interceptor
    }

    @Singleton
    @Provides
    fun provideTMDBService(retrofit: Retrofit) : TMDBService{
        return retrofit.create(TMDBService::class.java)
    }

}