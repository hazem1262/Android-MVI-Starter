package com.hazem.androidmvistarter.presentation.meals.mvi

import com.hazem.androidmvistarter.data.remote.meals.Meal

data class MainActivityState(
    val meals:List<Meal>
)