package com.example.androidtest

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidtest.ui.theme.TodoDetailScreen
import com.example.androidtest.ui.theme.TodoListScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            TodoListScreen(navController)
        }
        composable("detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull() ?: 0
            TodoDetailScreen(id)
        }
    }
}