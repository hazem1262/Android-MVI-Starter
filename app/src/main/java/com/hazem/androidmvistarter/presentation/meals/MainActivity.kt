package com.hazem.androidmvistarter.presentation.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hazem.androidmvistarter.ui.theme.AndroidMVIStarterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel:MainActivityViewModel  = viewModel()
            val state = viewModel.uiState.collectAsState().value
            AndroidMVIStarterTheme {
                // A surface container using the 'background' color from the theme
                LazyColumn {
                    items(
                        state.meals
                    ){ meal ->
                        Surface {
                            Text(text = meal.title.toString())
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