package com.arashaghelifar.api.di

import com.arashaghelifar.api.ApiConstants.BASE_URL
import com.arashaghelifar.api.ApiService
import com.arashaghelifar.api.DefaultApiSource
import com.arashaghelifar.datasource.ApiSource
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ApiModule {

    @Provides
    @Singleton
    fun provideApiService(
        okHttpClient: OkHttpClient,
        gson: Gson,
    ): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)

    }

    @Singleton
    @Provides
    internal fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(40, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(40, TimeUnit.SECONDS).build()

    }
}

@Module
@InstallIn(SingletonComponent::class)
internal abstract class ApiSourceModule {

    @Binds
    abstract fun bindLocalDatasource(defaultApiSource: DefaultApiSource): ApiSource
}



