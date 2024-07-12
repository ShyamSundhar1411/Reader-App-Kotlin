package com.example.readerapp.components.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.readerapp.components.common.RoundedButtonComponent
import com.example.readerapp.models.MBook

@Composable
fun ListCard(
    book: MBook = MBook("1234"),
    onPressDetails: (String) -> Unit = {}
) {
    val context = LocalContext.current
    val resources = context.resources
    val displayMetrics = resources.displayMetrics
    val screenWidth = displayMetrics.widthPixels
    val spacing = 10.dp
    Card(shape = RoundedCornerShape(29.dp),
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier
            .padding(16.dp)
            .width(202.dp)
            .height(242.dp)

            .clickable {

            },
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .width(screenWidth.dp - (spacing * 2)),
            horizontalAlignment = Alignment.Start
        ) {
            Row(horizontalArrangement = Arrangement.Center) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = ImageRequest.Builder(context)
                            .data(data = book.photoUrl.toString())
                            .build()
                    ),
                    contentDescription = "book image",
                    modifier = Modifier
                        .height(140.dp)
                        .width(100.dp)
                        .padding(4.dp)

                )
                Spacer(modifier = Modifier.width(50.dp))
                Column(
                    modifier = Modifier.padding(top = 25.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Rounded.FavoriteBorder,
                        contentDescription = "Favorite Icon",
                        modifier = Modifier.padding(bottom = 1.dp)
                    )
                    BookRating()

                }

            }
            Text(
                text = "Book title", modifier = Modifier.padding(4.dp),
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "Author All..", modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.bodySmall
            )

        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.Bottom) {
            RoundedButtonComponent(label = "Reading", radius = 70)
        }

    }
}

@Composable
fun BookRating(score: Double = 4.5) {
    Surface(
        modifier = Modifier
            .height(70.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(56.dp),
        color = Color.White,
        shadowElevation = 6.dp
    ) {
        Column(modifier = Modifier.padding(4.dp)) {
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = "Favorite Icon",
                modifier = Modifier.padding(bottom = 3.dp)
            )
            Text(text = score.toString(), style = MaterialTheme.typography.bodyLarge)
        }


    }

}


