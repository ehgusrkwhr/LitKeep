package com.dodo.litkeep.di

import android.content.Context
import com.dodo.litkeep.data.remote.api.BookApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    @Named("backupRecoveryClient")
    fun provideBackupRecoveryOkHttpClient(hli: HttpLoggingInterceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(hli)
        return httpClient
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(json: Json): Retrofit {
        val contentType = "application/json".toMediaType()
//        Moshi.Builder
        return Retrofit.Builder()
            .baseUrl("http://www.aladin.co.kr/ttb/api/") // 알라딘 base
//            .addConverterFactory(json.asConverterFactory(contentType)) // JSON 파싱용
            .addConverterFactory(SimpleXmlConverterFactory.create()) // JSON 파싱용
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): BookApiService {
        return retrofit.create(BookApiService::class.java)
    }

    @Provides
    @Singleton
    fun providerLoggingInterceptor(): HttpLoggingInterceptor {
//        return HttpLoggingInterceptor(CustomHttpLogger()).apply {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideJson(): Json {
        return Json { ignoreUnknownKeys = true }
    }

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }


}