package com.example.readerapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.readerapp.components.homescreen.FABComponent
import com.example.readerapp.components.common.ReaderTopBarComponent
import com.example.readerapp.components.homescreen.HomeContent
import com.example.readerapp.components.homescreen.TitleSection
import com.example.readerapp.models.MBook

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            ReaderTopBarComponent(title = "A.Reader",isMainScreen = true , navController = navController)
        },
        floatingActionButton = {
            FABComponent(onTap = {})
        }
    ) {
        Box(modifier = Modifier.padding(it)){
            HomeContent(navController = navController)
        }
    }
}

