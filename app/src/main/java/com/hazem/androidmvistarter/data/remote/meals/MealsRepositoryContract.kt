package com.hazem.androidmvistarter.data.remote.meals

interface MealsRepositoryContract {
    suspend fun getMeals():List<Meal>
}