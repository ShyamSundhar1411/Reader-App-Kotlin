package com.example.readerapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.readerapp.components.homescreen.FABComponent
import com.example.readerapp.components.common.ReaderTopBarComponent
import com.example.readerapp.components.homescreen.HomeContent
import com.example.readerapp.navigation.Routes
import com.example.readerapp.viewmodels.HomeViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    Scaffold(
        topBar = {
            ReaderTopBarComponent(title = "A.Reader", navController = navController)
        },
        floatingActionButton = {
            FABComponent(onTap = {
                navController.navigate(Routes.SearchScreen.name)
            })
        }
    ) {
        Box(modifier = Modifier.padding(it)){
            HomeContent(navController = navController, viewModel)
        }
    }
}

