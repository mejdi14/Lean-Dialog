package com.example.leanoverlay.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.leanoverlay.R

@Composable
 fun CloseIconComposable(showDialog: MutableState<Boolean>) {
    Box(
        contentAlignment = Alignment.TopEnd, modifier = Modifier
            .height(30.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.close),
            contentDescription = "Close Icon",
            modifier = Modifier
                .size(26.dp) // Set this to the size you want
                .align(Alignment.TopEnd)
                .rotate(4f)
                .clickable {
                    showDialog.value = false
                }
        )
    }
}