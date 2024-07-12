package com.example.readerapp.components.detailscreen

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.core.text.HtmlCompat
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.readerapp.components.common.RoundedButtonComponent
import com.example.readerapp.data.Resource
import com.example.readerapp.models.Item
import com.example.readerapp.models.MBook
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

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
    Text(
        text = bookData?.title.toString(),
        style = MaterialTheme.typography.bodyLarge,
        overflow = TextOverflow.Ellipsis,
        maxLines = 19
    )

    Text(text = "Authors: ${bookData?.authors.toString()}")
    Text(text = "Page Count: ${bookData?.pageCount.toString()}")
    Text(
        text = "Categories: ${bookData?.categories.toString()}",
        style = MaterialTheme.typography.bodySmall,
        maxLines = 3,
        overflow = TextOverflow.Ellipsis
    )
    Text(
        text = "Published: ${bookData?.publishedDate.toString()}",
        style = MaterialTheme.typography.bodySmall
    )

    Spacer(modifier = Modifier.height(5.dp))

//    val cleanDescription = HtmlCompat.fromHtml(
//        bookData!!.description,
//        HtmlCompat.FROM_HTML_MODE_LEGACY
//    )
    val localDims = LocalContext.current.resources.displayMetrics
//    Surface(
//        modifier = Modifier
//            .height(localDims.heightPixels.dp.times(0.09f))
//            .padding(4.dp),
//        shape = RectangleShape,
//        border = BorderStroke(1.dp, Color.DarkGray)
//    ) {
//
//
//        LazyColumn(modifier = Modifier.padding(3.dp)) {
//            item {
//                Text(text = bookData?.description.toString())
//            }
//        }
//
//    }
    Row(modifier = Modifier.padding(5.dp), horizontalArrangement = Arrangement.SpaceAround) {
        RoundedButtonComponent(label = "Save") {

            val book = MBook(
                title = bookData?.title,
                authors = bookData?.authors.toString(),
                description = bookData?.description,
                categories = bookData?.categories.toString(),
                notes = "",
                photoUrl = bookData?.imageLinks?.thumbnail,
                publishedDate = bookData?.publishedDate,
                pageCount = bookData?.pageCount.toString(),
                rating = 0.0,
                googleBookId = googleBookId,
                userId = FirebaseAuth.getInstance().currentUser?.uid.toString()
            )

            saveToFirebase(book, navController = navController)

        }
        Spacer(modifier = Modifier.width(25.dp))
        RoundedButtonComponent(label = "Cancel") {
            navController.popBackStack()
        }
    }


}


fun saveToFirebase(book: MBook, navController: NavController) {
    val db = FirebaseFirestore.getInstance()
    val dbCollection = db.collection("books")

    if (book.toString().isNotEmpty()) {
        dbCollection.add(book)
            .addOnSuccessListener { documentRef ->
                val docId = documentRef.id
                dbCollection.document(docId)
                    .update(hashMapOf("id" to docId) as Map<String, Any>)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            navController.popBackStack()
                        }
                    }.addOnFailureListener {
                        Log.w("Error", "SaveToFirebase:  Error updating doc", it)
                    }

            }


    } else { }


}