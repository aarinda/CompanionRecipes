package com.example.companionrecipes.data.dto.recipes_list

import com.example.companionrecipes.domain.model.recipes_list.Recipe

data class RecipeDto(
    val id: Int,
    val title: String,
    val image: String
)

fun RecipeDto.toRecipe(): Recipe {
    return Recipe(
        id = id,
        title = title,
        image = image,
    )
}