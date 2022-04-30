package com.hazem.androidmvistarter.presentation.meals.details

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hazem.androidmvistarter.data.remote.meals.Meal
import com.hazem.androidmvistarter.presentation.meals.details.fullScreenImage.FullImageScreen
import com.hazem.androidmvistarter.presentation.meals.details.views.MealDetailsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val meal: Meal? = intent.extras?.getParcelable(MEAL_EXTRA_KEY)
        setContent {
            val navController = rememberNavController()
            Scaffold {
                innerPadding -> MealDetailsNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding),
                meal = meal
            )
            }
        }
    }
    @Composable
    private fun MealDetailsNavHost(
        navController: NavHostController,
        modifier: Modifier = Modifier,
        meal: Meal?
    ) {
        NavHost(
            navController = navController,
            startDestination = DetailsScreen.MealDetails.name,
            modifier = modifier
        ) {
            composable(DetailsScreen.MealDetails.name){
                MealDetailsScreen(meal = meal)
            }

            composable(DetailsScreen.FullImage.name){
                FullImageScreen(meal = meal)
            }

        }
    }

    companion object{
        const val MEAL_EXTRA_KEY = "MEAL_EXTRA_KEY"
    }
}