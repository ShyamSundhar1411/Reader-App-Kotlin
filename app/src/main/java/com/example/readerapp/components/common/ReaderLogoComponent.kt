package com.example.readerapp.components.common

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ReaderLogoComponent(modifier: Modifier = Modifier){
    Text(
        text = "Reader",
        style = MaterialTheme.typography.headlineLarge,
        color = Color.Red.copy(0.5f),
    )
}