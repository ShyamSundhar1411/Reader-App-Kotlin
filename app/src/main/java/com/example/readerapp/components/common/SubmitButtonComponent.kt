package com.example.readerapp.components.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SubmitButton(
    textId:String,
    loading:Boolean,
    validInputs: Boolean,
    onClick: () -> Unit
){

    Button(
        onClick = onClick,
        enabled = !loading && validInputs,
        shape = CircleShape,
        modifier = Modifier.fillMaxWidth()
    ){
    if(loading){
        CircularProgressIndicator(modifier = Modifier.size(20.dp))
    }else{
        Text(text = textId, modifier = Modifier.padding(5.dp))
    }
    }
}