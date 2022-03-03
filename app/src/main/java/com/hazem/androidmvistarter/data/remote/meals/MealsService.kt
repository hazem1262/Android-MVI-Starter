package com.hazem.androidmvistarter.data.remote.meals

import com.hazem.androidmvistarter.utils.network.NetworkUtils.EndPoints.MEALS
import retrofit2.Response
import retrofit2.http.GET

interface MealsService {
    @GET(MEALS)
    suspend fun getMeals(): Response<List<Meal>>
}