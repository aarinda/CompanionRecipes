package com.example.companionrecipes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.companionrecipes.data.remote.Constants
import com.example.companionrecipes.recipes_details_screen.RecipesDetailsScreen
import com.example.companionrecipes.recipes_screen.RecipesScreen
import com.example.companionrecipes.theme.CompanionRecipesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompanionRecipesTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.RecipesScreen.route
                ) {
                    composable(
                        route = Screen.RecipesScreen.route
                    ) {
                        RecipesScreen(navController)
                    }
                    composable(
                        route = Screen.RecipesDetailsScreen.route + "/{id}",
                        arguments = listOf(
                            navArgument(Constants.PARAM_ID) {
                                type = NavType.IntType
                                defaultValue = 1
                            }
                        )
                    ) {
                        RecipesDetailsScreen(navController)
                    }
                }
            }
        }
    }
}


