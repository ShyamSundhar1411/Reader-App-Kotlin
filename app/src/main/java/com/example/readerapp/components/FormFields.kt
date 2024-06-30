package com.example.readerapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EmailInputField(modifier: Modifier = Modifier,
               emailState: MutableState<String>,
               labelId: String = "Email",
               enabled: Boolean = true,
               imeAction: ImeAction = ImeAction.Next,
               onAction: KeyboardActions = KeyboardActions.Default
){
  InputField(
      modifier = modifier,
      valueState = emailState,
      labelId = labelId,
      enabled = enabled,
      keyboardType = KeyboardType.Email,
      imeAction = imeAction,
      onAction = onAction
  )
}

@Composable
fun InputField(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    labelId: String = "Email",
    enabled: Boolean = true,
    isSingleLine: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default
){
    OutlinedTextField(value = valueState.value, onValueChange = {
        valueState.value = it
    },label = {Text(labelId)},
        singleLine = isSingleLine,
        textStyle = TextStyle(fontSize = 18.sp),
        modifier = modifier.padding(10.dp).fillMaxWidth(),
        enabled = enabled,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction)
        )
}