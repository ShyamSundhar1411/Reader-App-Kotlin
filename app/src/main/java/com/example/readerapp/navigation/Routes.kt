package com.example.readerapp.navigation

enum class Routes {
    SplashScreen,
    LoginScreen,
    SignUpScreen,
    SearchScreen,
    DetailScreen,
    HomeScreen,
    UpdateScreen,
    ReadersStatsScreen;
    companion object{
        fun fromRoute(route: String): Routes = when(route.substringBefore("/")){
            SplashScreen.name -> SplashScreen
            LoginScreen.name -> LoginScreen
            SignUpScreen.name -> SignUpScreen
            SearchScreen.name -> SearchScreen
            DetailScreen.name -> DetailScreen
            UpdateScreen.name -> UpdateScreen
            ReadersStatsScreen.name -> ReadersStatsScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}