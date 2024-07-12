package com.example.readerapp.components.detailscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.core.text.HtmlCompat
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.readerapp.data.Resource
import com.example.readerapp.models.Item

@Composable
fun BookDetailComponent(bookInfo: Resource<Item>, navController: NavController) {
    val bookData = bookInfo.data?.volumeInfo
    val googleBookId = bookInfo.data?.id
    Card(
        modifier = Modifier.padding(34.dp),
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(bookData?.imageLinks?.smallThumbnail).build()
            ), contentDescription = "Thumbnail",
            modifier = Modifier
                .padding(1.dp)
                .height(90.dp)
                .width(90.dp)
        )
    }
        Text(text = bookData?.title.toString(),
            style = MaterialTheme.typography.bodyLarge,
            overflow = TextOverflow.Ellipsis,
            maxLines = 19)

        Text(text = "Authors: ${bookData?.authors.toString()}")
        Text(text = "Page Count: ${bookData?.pageCount.toString()}")
        Text(text = "Categories: ${bookData?.categories.toString()}",
            style = MaterialTheme.typography.bodySmall,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis)
        Text(text = "Published: ${bookData?.publishedDate.toString()}",
            style = MaterialTheme.typography.bodySmall)

        Spacer(modifier = Modifier.height(5.dp))
        LazyColumn {

        }

}