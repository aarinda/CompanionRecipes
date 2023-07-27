package com.example.companionrecipes.domain.model.recipe_details

data class Ingredient(
    val image: String?,
    val name: String,
    val amount: Double,
    val unit: String,
)