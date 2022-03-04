package com.hazem.androidmvistarter.presentation.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.hazem.androidmvistarter.ui.theme.AndroidMVIStarterTheme
import com.hazem.androidmvistarter.utils.network.NetworkUtils.BASE_URL
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel:MainActivityViewModel  by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state = viewModel.uiState.collectAsState().value
            AndroidMVIStarterTheme {
                // A surface container using the 'background' color from the theme
                LazyColumn {
                    items(
                        state.meals
                    ){ meal ->
                        Card(elevation = 2.dp, modifier = Modifier.fillMaxWidth().padding(8.dp), shape = RoundedCornerShape(size = 16.dp)) {
                            Row (verticalAlignment = Alignment.CenterVertically){
                                Image(painter = rememberImagePainter("$BASE_URL${meal.image}"), contentDescription = null, modifier = Modifier.size(128.dp))
                                Text(text = meal.title.toString(), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidMVIStarterTheme {
        Greeting("Android")
    }
}