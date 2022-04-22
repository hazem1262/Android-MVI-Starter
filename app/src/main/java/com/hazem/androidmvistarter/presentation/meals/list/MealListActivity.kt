package com.hazem.androidmvistarter.presentation.meals.list

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.hazem.androidmvistarter.presentation.meals.list.views.MealsListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealListActivity : ComponentActivity() {
    private val viewModel: MealListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getMeals()
        setContent {
            Log.d("viewModel","viewModel inside main activity: ${viewModel.hashCode()}")
            val state = viewModel.uiState.collectAsState().value
            MealsListScreen(state.meals)
        }
    }
}