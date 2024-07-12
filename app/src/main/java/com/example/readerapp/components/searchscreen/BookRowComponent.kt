package com.example.readerapp.components.searchscreen

import androidx.compose.foundation.Image
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.readerapp.models.Item
import com.example.readerapp.navigation.Routes

@Composable
fun BookRowComponent(navController: NavController, book: Item){
    Card(onClick = {
        navController.navigate(Routes.DetailScreen.name+"/${book.volumeInfo.title}/${book.id}")
    },
        modifier = Modifier
            .clickable { }
            .fillMaxWidth()
            .height(100.dp)
            .padding(3.dp),
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(Color.White)
        ) {
        Row(modifier = Modifier.padding(5.dp),
            verticalAlignment = Alignment.Top
            ){
            val imageUrl: String = book.volumeInfo.imageLinks.smallThumbnail.ifEmpty { "https://images.unsplash.com/photo-1541963463532-d68292c34b19?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=80&q=80" }
            Image(
                painter = rememberAsyncImagePainter(model = ImageRequest.Builder(LocalContext.current).data(data = imageUrl).build()),
                contentDescription = "book image",
                modifier = Modifier
                    .width(80.dp)
                    .fillMaxHeight()
                    .padding(end = 4.dp),
            )
            Column() {
                Text(text = book.volumeInfo.title.toString(), overflow = TextOverflow.Ellipsis)
                Text(text = "Author: ${book.volumeInfo.authors}",
                    overflow = TextOverflow.Clip,
                    style = MaterialTheme.typography.labelSmall
                )
                Text(text =  "Date: ${book.volumeInfo.publishedDate}",
                    overflow = TextOverflow.Clip,
                    fontStyle = FontStyle.Italic,
                    style = MaterialTheme.typography.labelSmall)

                Text(text =  "${book.volumeInfo.categories}",
                    overflow = TextOverflow.Clip,
                    fontStyle = FontStyle.Italic,
                    style = MaterialTheme.typography.labelSmall)


            }
        }
    }
}
