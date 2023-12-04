package com.example.hoabhjetpack.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hoabhjetpack.view.*

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }

        composable(Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }

        composable(Screen.SignupScreen.route) {
            SignupScreen(navController = navController)
        }

        composable(Screen.HomeScreen.route) {
            Dashboard(navController = navController)
        }

        composable(Screen.TaskScreen.route) {
            HomeScreen(navController = navController)
        }

    }
}