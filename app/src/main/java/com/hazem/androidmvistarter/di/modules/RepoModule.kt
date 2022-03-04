package com.hazem.androidmvistarter.di.modules

import com.hazem.androidmvistarter.data.remote.meals.MealsRepository
import com.hazem.androidmvistarter.data.remote.meals.MealsRepositoryContract
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {
    @Binds
    abstract fun provideSettingsRepository(mealsRepository: MealsRepository): MealsRepositoryContract

}