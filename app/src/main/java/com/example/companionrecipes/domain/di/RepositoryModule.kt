package com.example.companionrecipes.domain.di

import com.example.companionrecipes.data.local.RecipeDetailsDao
import com.example.companionrecipes.data.remote.FoodRecipesApi
import com.example.companionrecipes.data.repository.RecipeRepositoryImpl
import com.example.companionrecipes.domain.repository.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideRecipeRepository(
        api: FoodRecipesApi, recipeDetailsDao: RecipeDetailsDao
    ): RecipeRepository {
        return RecipeRepositoryImpl(api, recipeDetailsDao)
    }
}