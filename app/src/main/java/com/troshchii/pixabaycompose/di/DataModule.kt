package com.troshchii.pixabaycompose.di

import com.troshchii.pixabaycompose.ui.hitlist.HitsRepository
import com.troshchii.pixabaycompose.ui.hitlist.HitsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule {

    @Binds
    abstract fun hitsRepository(repository: HitsRepositoryImpl): HitsRepository

}
