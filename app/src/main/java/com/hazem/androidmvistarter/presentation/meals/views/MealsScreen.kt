package com.hazem.androidmvistarter.presentation.meals.views

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hazem.androidmvistarter.data.remote.meals.Meal
import com.hazem.androidmvistarter.presentation.meals.MainActivityViewModel
import com.hazem.androidmvistarter.ui.theme.AndroidMVIStarterTheme

@Composable
fun MealsScreen(meals:List<Meal>) {
    // shared view model between all composable functions in the same activity
    val viewModel:MainActivityViewModel = viewModel()
    Log.d("viewModel","viewModel inside meals screen: ${viewModel.hashCode()}")
    AndroidMVIStarterTheme {
        LazyColumn {
            items(
                meals
            ){ meal -> MealItem(meal = meal) }
        }
    }
}