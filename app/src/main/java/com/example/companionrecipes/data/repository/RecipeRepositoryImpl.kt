package com.example.companionrecipes.data.repository

import com.example.companionrecipes.data.dto.recipe_details.RecipeDetailsDto
import com.example.companionrecipes.data.dto.recipes_list.toRecipesResponse
import com.example.companionrecipes.data.local.RecipeDetailsDao
import com.example.companionrecipes.data.remote.FoodRecipesApi
import com.example.companionrecipes.domain.model.recipes_list.RecipesResponse
import com.example.companionrecipes.domain.repository.RecipeRepository
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val api: FoodRecipesApi,
    private val recipeDetailsDao: RecipeDetailsDao
) : RecipeRepository {

    override suspend fun fetchRecipes(offset: Int): RecipesResponse {
        return api.getRandomRecipes(offset).toRecipesResponse()
    }

    override suspend fun fetchRecipesDetails(id: Int): RecipeDetailsDto {
        return api.getRecipeDetails(id)
    }

    override suspend fun getRecipeDetails(id: Int): RecipeDetailsDto? {
        return recipeDetailsDao.getRecipeDetails(id)
    }

    override suspend fun cacheRecipeDetails(recipeDetails: RecipeDetailsDto) {
        recipeDetailsDao.cacheRecipeDetails(recipeDetails)
    }
}