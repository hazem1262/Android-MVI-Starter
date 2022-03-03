package com.hazem.androidmvistarter.data.remote.meals

import com.hazem.androidmvistarter.base.BaseRepository
import com.hazem.androidmvistarter.utils.coroutines.ContextProviders

class MealsRepository(
    private val contextProviders: ContextProviders,
    private val mealsService: MealsService
): BaseRepository(contextProviders) {
    suspend fun getMeals():List<Meal>?{
        return launchBlock{
            return@launchBlock mealsService.getMeals()
        }
    }
}