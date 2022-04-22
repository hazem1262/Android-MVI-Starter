package com.hazem.androidmvistarter.presentation.details

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.hazem.androidmvistarter.data.remote.meals.Meal
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val meal: Meal? = intent.extras?.getParcelable(MEAL_EXTRA_KEY)
        setContent {
            Box(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(color = Color.Cyan)) {
                Text(text = meal?.title ?: "")
            }
        }
    }

    companion object{
        const val MEAL_EXTRA_KEY = "MEAL_EXTRA_KEY"
    }
}