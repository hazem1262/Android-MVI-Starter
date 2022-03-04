package com.hazem.androidmvistarter.data.remote.meals

import com.hazem.androidmvistarter.base.BaseRepository
import com.hazem.androidmvistarter.utils.coroutines.ContextProviders
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class MealsRepository @Inject constructor(
    private val contextProviders: ContextProviders,
    private val mealsService: MealsService
): BaseRepository(contextProviders), MealsRepositoryContract {
    override suspend fun getMeals():List<Meal>{
        return launchBlock{
            return@launchBlock mealsService.getMeals()
        }
    }
}