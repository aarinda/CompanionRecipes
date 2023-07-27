package com.example.companionrecipes.domain.model.recipes_list

data class RecipesResponse(
    val offset: Int,
    val results: List<Recipe>,
)