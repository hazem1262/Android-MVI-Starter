package com.hazem.androidmvistarter.presentation.meals.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.hazem.androidmvistarter.data.remote.meals.Meal
import com.hazem.androidmvistarter.ui.theme.AndroidMVIStarterTheme

@Composable
fun MealsScreen(meals:List<Meal>) {
    AndroidMVIStarterTheme {
        LazyColumn {
            items(
                meals
            ){ meal -> MealItem(meal = meal) }
        }
    }
}