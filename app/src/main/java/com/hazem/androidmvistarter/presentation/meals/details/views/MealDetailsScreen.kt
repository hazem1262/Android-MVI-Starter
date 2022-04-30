package com.hazem.androidmvistarter.presentation.meals.details.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.hazem.androidmvistarter.data.remote.meals.Meal
import com.hazem.androidmvistarter.utils.network.NetworkUtils

@Composable
fun MealDetailsScreen(
    meal:Meal?,
    onClickSeeAllBills: () -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = meal?.title ?: "No Meal",
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp),
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.W800,
        )
        Image(
            painter = rememberImagePainter("${NetworkUtils.BASE_URL}${meal?.image}"),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(10))
                .clickable {
                    onClickSeeAllBills()
                },
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp),
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.W400,
        )
    }
}