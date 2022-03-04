package com.hazem.androidmvistarter.di.modules

import com.hazem.androidmvistarter.data.remote.meals.MealsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class NetworkModule {
    @Provides
    fun provideMealsService(retrofit: Retrofit):MealsService {
        return retrofit.create(MealsService::class.java)
    }
}