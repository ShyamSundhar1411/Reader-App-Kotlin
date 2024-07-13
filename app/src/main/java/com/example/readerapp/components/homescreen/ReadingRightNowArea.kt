package com.example.readerapp.components.homescreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.readerapp.models.MBook

@Composable
fun ReadingRightNowAreaComponent(listOfBooks: List<MBook>,
                        navController: NavController
) {
    val readingNowList = listOfBooks.filter { mBook ->
        mBook.startedReading != null && mBook.finishedReading == null
    }

    HorizontalScrollableComponent(readingNowList){

    }



}