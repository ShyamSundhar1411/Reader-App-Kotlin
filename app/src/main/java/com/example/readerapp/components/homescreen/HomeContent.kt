package com.example.readerapp.components.homescreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.readerapp.models.MBook
import com.example.readerapp.navigation.Routes
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HomeContent(navController: NavController){

    val email = FirebaseAuth.getInstance().currentUser?.email
    val currentUserName = if (!email.isNullOrEmpty()) email.split("@")[0] else "NA"
    val listOfBooks = listOf(
          MBook(id = "dadfa", title = "Hello Again", authors = "All of us", notes = null),
        MBook(id = "dadfa", title = " Again", authors = "All of us", notes = null),
        MBook(id = "dadfa", title = "Hello ", authors = "The world us", notes = null),
        MBook(id = "dadfa", title = "Hello Again", authors = "All of us", notes = null),
        MBook(id = "dadfa", title = "Hello Again", authors = "All of us", notes = null)
                            )
    Column(modifier = Modifier
        .padding(2.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        Row(modifier = Modifier.align(Alignment.Start)){
            TitleSection(label = "Your reading \n" +"activity right now...")
            Spacer(modifier = Modifier.fillMaxWidth(0.7f))
            Column(modifier = Modifier.align(Alignment.CenterVertically),) {
                Icon(imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "profile",
                    modifier = Modifier
                        .size(45.dp)
                        .clickable {
                            navController.navigate(Routes.ReadersStatsScreen.name)
                        },
                    tint = MaterialTheme.colorScheme.secondary
                    )

                Text(text = currentUserName,
                    modifier = Modifier.padding(top = 5.dp),
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Red,
                    maxLines = 1,
                    fontSize = 15.sp,
                    overflow = TextOverflow.Clip
                    )
                HorizontalDivider()

            }
        }
        ListCard()
        ReadingListAreaComponent(listOfBooks = listOfBooks, navController = navController)
    }
}