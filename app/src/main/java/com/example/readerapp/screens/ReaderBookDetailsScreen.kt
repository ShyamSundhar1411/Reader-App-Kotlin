package com.example.readerapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.readerapp.components.common.ReaderTopBarComponent
import com.example.readerapp.data.Resource
import com.example.readerapp.models.Item
import com.example.readerapp.viewmodels.BookViewModel
import com.example.readerapp.viewmodels.DetailsViewModel

@Composable
fun BookDetailsScreen(navController: NavController, bookId:String,title: String,viewModel: DetailsViewModel = hiltViewModel()) {
    Scaffold(topBar = {
        ReaderTopBarComponent(
            title = title,
            icon = Icons.AutoMirrored.Filled.ArrowBack,
            showProfile = false,
            navController = navController
        ) {
            navController.popBackStack()
        }
    }) {
        Column(modifier = Modifier.padding(it)) {
            val bookInfo = produceState<Resource<Item>>(initialValue = Resource.Loading()) {
                value = viewModel.getBookInfo(bookId)
            }.value
            if (bookInfo.data == null) {

                    LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
                

            } else {
                Text(text = bookInfo.data.volumeInfo.title.toString())
            }
        }
    }
}