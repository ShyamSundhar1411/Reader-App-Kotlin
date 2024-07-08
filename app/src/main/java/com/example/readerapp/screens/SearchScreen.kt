package com.example.readerapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.readerapp.components.common.ReaderTopBarComponent
import com.example.readerapp.components.searchscreen.SearchFormComponent
import com.example.readerapp.models.MBook

@Composable
fun SearchScreen(navController: NavController){
    val listOfBooks = listOf(
        MBook(id = "dadfa", title = "Hello Again", authors = "All of us", notes = null),
        MBook(id = "dadfa", title = " Again", authors = "All of us", notes = null),
        MBook(id = "dadfa", title = "Hello ", authors = "The world us", notes = null),
        MBook(id = "dadfa", title = "Hello Again", authors = "All of us", notes = null),
        MBook(id = "dadfa", title = "Hello Again", authors = "All of us", notes = null)
    )
    Scaffold(
        topBar = {
            ReaderTopBarComponent(
                title = "Search Books",
                showProfile = false,
                icon = Icons.AutoMirrored.Filled.ArrowBack,
                navController = navController,
            ){
                navController.popBackStack()
            }
        }
    ) {
        Box(modifier = Modifier.padding(it)){
            SearchFormComponent(modifier = Modifier.fillMaxWidth().padding(16.dp))
        }
    }
}