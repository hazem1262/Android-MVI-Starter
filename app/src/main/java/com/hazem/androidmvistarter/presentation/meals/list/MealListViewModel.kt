package com.hazem.androidmvistarter.presentation.meals.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hazem.androidmvistarter.data.remote.meals.MealsRepositoryContract
import com.hazem.androidmvistarter.presentation.meals.list.mvi.MainActivityState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealListViewModel @Inject constructor(
    private val mealsRepository: MealsRepositoryContract
): ViewModel()  {
    val uiState = MutableStateFlow(MainActivityState(arrayListOf()))

    fun getMeals(){
        viewModelScope.launch {
            val meals = mealsRepository.getMeals()
            uiState.value = uiState.value.copy(meals = meals)
        }
    }
}