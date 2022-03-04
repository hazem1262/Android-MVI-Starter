package com.hazem.androidmvistarter.presentation.meals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hazem.androidmvistarter.data.remote.meals.MealsRepository
import com.hazem.androidmvistarter.data.remote.meals.MealsService
import com.hazem.androidmvistarter.presentation.meals.mvi.MainActivityState
import com.hazem.androidmvistarter.utils.coroutines.ContextProviders
import com.hazem.androidmvistarter.utils.network.NetworkUtils.BASE_URL
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(

): ViewModel()  {
    val uiState = MutableStateFlow(MainActivityState(arrayListOf()))
    val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .client(provideHttpClient())
    .build()
    val repository = MealsRepository(contextProviders = ContextProviders.getInstance(), mealsService = retrofit.create(
        MealsService::class.java))

    private fun provideHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        okHttpClientBuilder.addInterceptor(logging)
        return okHttpClientBuilder.build()
    }

    init {
        getMeals()
    }
    fun getMeals(){
        viewModelScope.launch {
            val meals = repository.getMeals()
            uiState.value = uiState.value.copy(meals = meals?: arrayListOf())
        }
    }
}