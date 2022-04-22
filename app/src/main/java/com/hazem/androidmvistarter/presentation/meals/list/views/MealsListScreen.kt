package com.hazem.androidmvistarter.presentation.meals.list.views

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hazem.androidmvistarter.data.remote.meals.Meal
import com.hazem.androidmvistarter.presentation.meals.list.MealListViewModel
import com.hazem.androidmvistarter.ui.theme.AndroidMVIStarterTheme

@Composable
fun MealsListScreen(meals:List<Meal>) {
    // shared view model between all composable functions in the same activity
    val viewModel: MealListViewModel = viewModel()
    Log.d("viewModel","viewModel inside meals screen: ${viewModel.hashCode()}")
    AndroidMVIStarterTheme {
        LazyColumn {
            items(
                meals
            ){ meal -> MealListItem(meal = meal) }
        }
    }
}