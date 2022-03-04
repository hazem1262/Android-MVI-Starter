package com.hazem.androidmvistarter.presentation.meals

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.hazem.androidmvistarter.presentation.meals.views.MealsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel:MainActivityViewModel  by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getMeals()
        setContent {
            Log.d("viewModel","viewModel inside main activity: ${viewModel.hashCode()}")
            val state = viewModel.uiState.collectAsState().value
            MealsScreen(state.meals)
        }
    }
}