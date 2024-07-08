package com.example.readerapp.components.homescreen

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.readerapp.models.MBook

@Composable
fun HorizontalScrollableComponent(listOfBooks: List<MBook>, onPressCard: (String) -> Unit = {}) {
    val scrollState = rememberScrollState()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .heightIn(200.dp)
            .horizontalScroll(scrollState)
    ) {
        for (book in listOfBooks) {
            ListCard(book) {
                onPressCard(it)
            }
        }
    }
}

@Composable
fun ReadingListAreaComponent(
    listOfBooks: List<MBook>,
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
        Text("Reading List", modifier = Modifier.padding(10.dp))
        HorizontalScrollableComponent(listOfBooks){
        }

    }
}