package com.example.readerapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.readerapp.components.common.ReaderTopBarComponent
import com.example.readerapp.components.detailscreen.BookDetailComponent
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
        Box(modifier = Modifier.padding(it).fillMaxSize()) {
            val bookInfo = produceState<Resource<Item>>(initialValue = Resource.Loading()) {
                value = viewModel.getBookInfo(bookId)
            }.value
            Column(modifier = Modifier.padding(18.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
                ) {

                if (bookInfo.data == null) {

                    LinearProgressIndicator(modifier = Modifier.fillMaxWidth())


                } else {
                    Box{}
                }
                BookDetailComponent(bookInfo = bookInfo, navController = navController)
            }
        }
    }
}