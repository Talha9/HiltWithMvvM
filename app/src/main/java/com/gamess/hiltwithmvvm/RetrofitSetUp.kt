package com.gamess.hiltwithmvvm
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitSetUp {

    @Singleton
    @Provides
    @Named("okHttpProvideSetting")
    fun okHttpProvideSetting(): OkHttpClient.Builder = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(1, TimeUnit.MINUTES)
        .writeTimeout(1, TimeUnit.MINUTES)


    @Singleton
    @Provides
    @Named("provideConverterFactory")
    fun provideConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()


    @Singleton
    @Provides
    @Named("httpLoggingInterceptor")
    fun httpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


    @Singleton
    @Provides
    @Named("okHttpClient")
    fun provideHttpClient(
        @Named("okHttpProvideSetting") provideSetting: OkHttpClient.Builder,
        @Named("httpLoggingInterceptor") httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient.Builder =
        provideSetting.addInterceptor(httpLoggingInterceptor)


}
