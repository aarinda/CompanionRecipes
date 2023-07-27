package com.example.companionrecipes.domain.repository

import com.example.companionrecipes.data.dto.recipe_details.RecipeDetailsDto
import com.example.companionrecipes.domain.model.recipes_list.RecipesResponse

interface RecipeRepository {
    suspend fun fetchRecipes(offset: Int): RecipesResponse

    suspend fun fetchRecipesDetails(id: Int): RecipeDetailsDto

    suspend fun getRecipeDetails(id: Int): RecipeDetailsDto?

    suspend fun cacheRecipeDetails(recipeDetails: RecipeDetailsDto)
}