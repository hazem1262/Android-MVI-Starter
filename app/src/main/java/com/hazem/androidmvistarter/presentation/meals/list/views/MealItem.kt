package com.hazem.androidmvistarter.presentation.meals.list.views

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.hazem.androidmvistarter.data.remote.meals.Meal
import com.hazem.androidmvistarter.presentation.details.MealDetailsActivity
import com.hazem.androidmvistarter.utils.extensions.getActivity
import com.hazem.androidmvistarter.utils.network.NetworkUtils

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MealItem(meal: Meal, context:Context = LocalContext.current) {
    Card(
        elevation = 2.dp,
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        shape = RoundedCornerShape(size = 16.dp),
        onClick = {
            context.startActivity(Intent(context, MealDetailsActivity::class.java))
        }
    ) {
        Row (verticalAlignment = Alignment.CenterVertically){
            Image(painter = rememberImagePainter("${NetworkUtils.BASE_URL}${meal.image}"), contentDescription = null, modifier = Modifier.size(128.dp))
            Text(text = meal.title.toString(), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        }
    }
}