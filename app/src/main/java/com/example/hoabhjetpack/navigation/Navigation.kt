package com.example.hoabhjetpack.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arvind.jetcomposeloginui.navigation.Screen
import com.arvind.jetcomposeloginui.view.*
import com.example.hoabhjetpack.view.CheckoutScreen

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
        composable(Screen.PopularListScreen.route) {
            PopularListScreen(navController = navController)
        }
        composable(Screen.DetailsScreen.route) {
            FlowerDetailsScreen(navController = navController)
        }
        composable(Screen.AddToCartScreen.route) {
            CheckoutScreen()
        }

    }
}