package com.troshchii.pixabaycompose.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Named("ApiKey")
    @Provides
    fun provideApiKey() = "26892743-13cdf2daccf8ccd822d236213"
}
