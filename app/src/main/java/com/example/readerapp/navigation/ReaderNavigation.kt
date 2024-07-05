package com.example.readerapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.readerapp.screens.HomeScreen
import com.example.readerapp.screens.LoginScreen
import com.example.readerapp.screens.ReaderSplashScreen
import com.example.readerapp.screens.ReadersStatsScreen

@Composable
fun ReaderNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.SplashScreen.name) {

        composable(Routes.SplashScreen.name) {
            ReaderSplashScreen(navController = navController)
        }
        composable(Routes.LoginScreen.name) {
            LoginScreen(navController = navController)
        }
        composable(Routes.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        composable(Routes.ReadersStatsScreen.name) {
            ReadersStatsScreen(navController)
        }


    }
}