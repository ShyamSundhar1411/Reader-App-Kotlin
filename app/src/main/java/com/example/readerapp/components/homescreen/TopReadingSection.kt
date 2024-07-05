package com.example.readerapp.components.homescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.readerapp.models.MBook

@Composable
fun ReadingRightNowArea(books: List<MBook>){
    Surface(modifier = Modifier.padding(start = 5.dp,top = 1.dp)){
        Column{


        }
    }
}

@Composable
fun TitleSection(modifier: Modifier = Modifier,label: String) {
    Surface(modifier = Modifier.padding(start = 5.dp, top = 1.dp)) {
        Column {
            Text(
                text = label,
                fontSize = 19.sp,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Left,

            )
        }

    }
}