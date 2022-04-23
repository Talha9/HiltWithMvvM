package com.gamess.hiltwithmvvm
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitBaseUrlFourSquare {

    @Singleton
    @Provides
    @Named("fourSquareBaseUrl")
    fun provideRetrofit(
        @Named("okHttpClient") okHttpClient: OkHttpClient.Builder,
        @Named("provideConverterFactory") gsonConvertorFactory: GsonConverterFactory
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.foursquare.com/")
            .addConverterFactory(gsonConvertorFactory)
            .client(okHttpClient.build())
            .build()


    @Singleton
    @Provides
    @Named("retrofitServiceFourSquare")
    fun retrofitServiceFourSquare(@Named("fourSquareBaseUrl") retrofit: Retrofit): ApiInterface =
        retrofit.create(ApiInterface::class.java)
}