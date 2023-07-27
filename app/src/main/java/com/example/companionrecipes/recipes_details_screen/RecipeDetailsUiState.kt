package com.example.companionrecipes.presentation

import com.example.companionrecipes.domain.model.recipe_details.RecipeDetails

sealed class RecipeDetailsUiState {
    object Loading : RecipeDetailsUiState()
    class Loaded(val data: RecipeDetails) : RecipeDetailsUiState()
    class Error(val message: String) : RecipeDetailsUiState()
}