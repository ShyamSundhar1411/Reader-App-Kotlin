package com.example.readerapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.readerapp.components.common.ReaderTopBarComponent
import com.example.readerapp.components.searchscreen.BookRowComponent
import com.example.readerapp.components.searchscreen.SearchFormComponent
import com.example.readerapp.viewmodels.BookViewModel

@Composable
fun SearchScreen(navController: NavController,viewModel: BookViewModel = hiltViewModel()){
    val listOfBooks = viewModel.list
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
        Column(modifier = Modifier.padding(it).fillMaxSize()){
            SearchFormComponent(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .padding(16.dp), viewModel = viewModel){query ->
                viewModel.searchBooks(query)
            }
            if(viewModel.isLoading){
                Row(
                    modifier = Modifier.padding(end = 2.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically) {
                    LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
                }
            }else {
                Text(text = viewModel.error.toString())
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    items(items = listOfBooks) { book ->
                        BookRowComponent(navController = navController, book = book)
                    }
                }
            }
        }

    }
}