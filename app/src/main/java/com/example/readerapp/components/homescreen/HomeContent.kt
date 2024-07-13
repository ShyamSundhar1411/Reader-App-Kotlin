package com.example.readerapp.components.homescreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.readerapp.models.MBook
import com.example.readerapp.navigation.Routes
import com.example.readerapp.viewmodels.HomeViewModel
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HomeContent(navController: NavController, viewModel: HomeViewModel = hiltViewModel()){
    var listOfBooks = emptyList<MBook>()
    val email = FirebaseAuth.getInstance().currentUser?.email
    val currentUserName = if (!email.isNullOrEmpty()) email.split("@")[0] else "NA"
    val currentUser = FirebaseAuth.getInstance().currentUser

    if(!viewModel.data.value.data.isNullOrEmpty()){
        listOfBooks = viewModel.data.value.data!!.toList().filter { mBook -> mBook.userId == currentUser?.uid.toString() }
    }

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
        ReadingRightNowAreaComponent(listOfBooks = listOfBooks,
            navController =navController )
        ReadingListAreaComponent(listOfBooks = listOfBooks, navController = navController)
    }
}