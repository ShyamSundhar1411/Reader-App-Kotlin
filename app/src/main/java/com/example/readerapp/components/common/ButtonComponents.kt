package com.example.readerapp.components.common


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


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

@Composable
fun RoundedButtonComponent(
    label: String = "Reading",
    radius: Int = 29,
    onPress: () -> Unit = {}
) {
    Surface(
        modifier = Modifier.clip(RoundedCornerShape(bottomEnd = radius.dp, topStart = radius.dp)),
        color = Color(0xFF92CBDF)
    ) {
        Column(
            modifier = Modifier
                .width(90.dp)
                .heightIn(40.dp)
                .clickable {
                    onPress.invoke()
                },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = label, style = TextStyle(color = Color.White, fontSize = 15.sp)
            )
        }
    }
}