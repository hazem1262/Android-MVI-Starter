package com.hazem.androidmvistarter.presentation.meals.details.fullScreenImage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.hazem.androidmvistarter.data.remote.meals.Meal
import com.hazem.androidmvistarter.utils.network.NetworkUtils

@Composable
fun FullImageScreen(meal: Meal?) {
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