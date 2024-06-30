package com.example.readerapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.navigation.NavController
import com.example.readerapp.components.LoginFormComponent
import com.example.readerapp.components.ReaderLogoComponent

@Composable
fun LoginScreen(navController: NavController){
    Text(text = "Login Screen")
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ReaderLogoComponent()
            LoginFormComponent(navController = navController)
        }
    }
}