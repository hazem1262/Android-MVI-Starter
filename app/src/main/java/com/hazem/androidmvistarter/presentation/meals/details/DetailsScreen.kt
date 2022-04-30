package com.hazem.androidmvistarter.presentation.meals.details

enum class DetailsScreen {
    MealDetails, FullImage;

    companion object {
        fun fromRoute(route: String?): DetailsScreen =
            when (route?.substringBefore("/")) {
                MealDetails.name -> MealDetails
                FullImage.name -> FullImage
                null -> MealDetails
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}