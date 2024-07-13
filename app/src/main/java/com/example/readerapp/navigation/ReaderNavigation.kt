package com.example.readerapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.readerapp.screens.BookDetailsScreen
import com.example.readerapp.screens.HomeScreen
import com.example.readerapp.screens.LoginScreen
import com.example.readerapp.screens.ReaderSplashScreen
import com.example.readerapp.screens.ReadersStatsScreen
import com.example.readerapp.screens.SearchScreen
import com.example.readerapp.viewmodels.HomeViewModel

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
            val homeViewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(navController = navController, viewModel = homeViewModel)
        }
        composable(Routes.ReadersStatsScreen.name) {
            ReadersStatsScreen(navController)
        }
        composable(Routes.SearchScreen.name){
            SearchScreen(navController = navController)
        }
        val detailRoute = Routes.DetailScreen.name
        composable("$detailRoute/{title}/{bookId}", arguments = listOf(navArgument("bookId") {
            type = NavType.StringType
        },
            navArgument("title") {
                type = NavType.StringType
            }
        )
        ) {
            val title = it.arguments?.getString("title")
            val bookId = it.arguments?.getString("bookId")
            BookDetailsScreen(
                navController = navController,
                bookId = bookId.toString(),
                title = title.toString()
            )
        }
    }
}