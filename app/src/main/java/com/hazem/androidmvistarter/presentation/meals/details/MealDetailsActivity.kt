package com.hazem.androidmvistarter.presentation.meals.details

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.hazem.androidmvistarter.data.remote.meals.Meal
import com.hazem.androidmvistarter.utils.network.NetworkUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val meal: Meal? = intent.extras?.getParcelable(MEAL_EXTRA_KEY)
        setContent {
            Column(modifier = Modifier) {
                Text(text = meal?.title ?: "")
                Image(
                    painter = rememberImagePainter("${NetworkUtils.BASE_URL}${meal?.image}"),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(10)),
                    contentScale = ContentScale.FillWidth

                )
            }
        }
    }

    companion object{
        const val MEAL_EXTRA_KEY = "MEAL_EXTRA_KEY"
    }
}