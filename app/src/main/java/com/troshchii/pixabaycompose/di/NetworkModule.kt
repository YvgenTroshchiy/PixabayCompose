package com.troshchii.pixabaycompose.di

import com.troshchii.pixabaycompose.network.HitsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Named("baseUrl")
    @Provides
    fun provideBaseUrl() = "https://pixabay.com/api/"

    @Provides
    fun provideApiService(@Named("baseUrl") baseUrl: String): HitsApi {
        val retrofit =
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit.create(HitsApi::class.java)
    }
}
