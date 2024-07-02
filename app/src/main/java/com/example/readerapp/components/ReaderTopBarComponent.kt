package com.example.readerapp.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.readerapp.navigation.Routes
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReaderTopBarComponent(
    title: String,
    isMainScreen: Boolean,
    showProfile: Boolean = true,
    navController: NavController,
    ){
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically){
                if(showProfile){
                    Icon(imageVector = Icons.Default.Person,
                        contentDescription = "Profile",
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(12.dp)
                            )
                            .scale(0.6f)
                        )

                }
                Text(
                    text = title,
                    color = Color.Red.copy(alpha = 0.7f),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                )
                Spacer(modifier = Modifier.width(150.dp))
            }
        },
        actions = {
                  IconButton(onClick = {
                      FirebaseAuth.getInstance().signOut().run {
                          navController.navigate(Routes.LoginScreen.name)
                      }
                    }
                      ){
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                            contentDescription = "Logout",
                            tint = Color.Red.copy(alpha = 0.4f)
                        )
                    }

        },

    )

}