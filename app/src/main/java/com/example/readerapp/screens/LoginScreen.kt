package com.example.readerapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.readerapp.components.common.ReaderLogoComponent
import com.example.readerapp.components.common.UserFormComponent
import com.example.readerapp.viewmodels.AuthViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.readerapp.navigation.Routes

@Composable
fun LoginScreen(navController: NavController,
                viewModel: AuthViewModel = viewModel(),
                ){

    val showLoginForm = rememberSaveable { mutableStateOf(true) }
    Surface(modifier = Modifier.fillMaxSize().padding(10.dp),
        ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(15.dp)
        ) {
            ReaderLogoComponent()
            if (showLoginForm.value) {
                UserFormComponent(navController = navController,loading = false) { email, password ->
                    viewModel.signInWithEmailAndPassword(email, password){
                        navController.navigate(Routes.HomeScreen.name)
                    }
                }

            } else {
                UserFormComponent(
                    navController = navController,
                    loading = false,
                    isCreateAccount = true
                ) { email, password ->
                    viewModel.createUserWithEmailAndPassword(email, password){
                        navController.navigate(Routes.HomeScreen.name)
                    }
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier.padding(15.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val text = if (showLoginForm.value) "Sign Up" else "Login"
                Text(
                    text = if (showLoginForm.value) "New User? " else "Already Have an Account? "
                )
                Text(
                    text = text,
                    modifier = Modifier.clickable { showLoginForm.value = !showLoginForm.value }.
                    padding(start = 5.dp),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.secondary

                )
            }
        }
    }
}