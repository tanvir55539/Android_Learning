package com.example.recipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController){
    val recipeViewModel: MainViewModel = viewModel()
    val viewstate by recipeViewModel.categoriesState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route)
    {
        composable(route = Screen.RecipeScreen.route){
            RecipeScreen(viewstate = viewstate, navigateToDetail = {
                // This part is responsible for parssing data from the current screen to the detail screen
                // It utilizes the saveStateHandel, Which is a component of the Compose navigation framwork
                navController.currentBackStackEntry?.savedStateHandle?.set("cat",it)
                navController.navigate(Screen.DetailScreen.route)
            })
        }
        composable(route= Screen.DetailScreen.route){
            val category = navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat")?: Category("","","","")
            CategoryDetailsScreen(category = category)
        }
    }
}