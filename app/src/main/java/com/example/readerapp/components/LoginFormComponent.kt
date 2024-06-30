package com.example.readerapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginFormComponent(navController: NavController,
                       loading: Boolean = false,
                       isCreateAccount: Boolean = false,
                       onDone: (String, String) -> Unit = { email, pwd ->}) {

    val email = rememberSaveable {
        mutableStateOf("")
    }
    val password = rememberSaveable {
        mutableStateOf("")
    }
    val passwordVisibility = rememberSaveable {
        mutableStateOf(false)
    }
    val passwordFocusRequest = FocusRequester.Default
    val keyboardController = LocalSoftwareKeyboardController.current
    val valid = remember(email,password) {
        email.value.trim().isNotEmpty() && password.value.trim().isNotEmpty()
    }
    Column(
        modifier = Modifier
            .height(250.dp)
            .padding(10.dp)
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmailInputField(emailState = email, enabled = !loading, onAction = KeyboardActions {
            passwordFocusRequest.requestFocus()
        })
        PasswordInputField(
            modifier = Modifier,
            passwordState = password, enabled = !loading,
            passwordVisibility = passwordVisibility,
            onAction = KeyboardActions{
                if(!valid) return@KeyboardActions
                onDone(email.value.trim(),password.value.trim())
            }
        )
        SubmitButton(textId = if(isCreateAccount)"Create Account" else "Login", loading = loading, validInputs = valid) {
            onDone(email.value.trim(),password.value.trim())
            keyboardController?.hide()

        }

    }
}