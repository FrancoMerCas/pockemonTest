package com.franco.test.presentation.di

import com.franco.test.BuildConfig
import com.franco.test.data.api.APIService
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
class NetModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        httpClient.addInterceptor { chain ->
            var original = chain.request()
            original = original.newBuilder()
                .build()
            val originalHttpUrl = original.url
            val url = originalHttpUrl.newBuilder().build()

            chain.proceed(original.newBuilder().url(url).build())
        }

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.URL)
            .client(httpClient.build())
            .build()
    }

    @Singleton
    @Provides
    fun provideAPIService(retrofit: Retrofit) : APIService {
        return retrofit.create(APIService::class.java)
    }
}