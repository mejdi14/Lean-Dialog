package com.example.leanoverlay.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.example.leanoverlay.data.DrawRoundRectParams

@Composable
fun StackedCards(
    showDialog: MutableState<Boolean>,
    modifier: Modifier = Modifier,
    drawRoundRectParams: DrawRoundRectParams = DrawRoundRectParams(),
    bodyContentExample: @Composable () -> Unit
) {
    Box(contentAlignment = Alignment.Center, modifier = modifier.then(Modifier.padding(top = 10.dp, bottom = 10.dp))) {
        Canvas(
            modifier = modifier.then(Modifier
                .align(Alignment.Center))
        ) {
            val size = this.size

            with(drawRoundRectParams) {
                drawRoundRect(
                    color = color,
                    topLeft = topLeft,
                    size = size,
                    cornerRadius = cornerRadius,
                    style = Stroke(width = strokeWidth)
                )
            }
        }

        Card(
            modifier = modifier.then(Modifier
                .align(Alignment.Center)
                .rotate(-4f)),
            backgroundColor = Color.White,
            shape = RoundedCornerShape(10.dp)
        ) {
            Box(contentAlignment = Alignment.TopEnd, modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp, end = 5.dp, top = 5.dp)
                ) {
                    CloseIconComposable(showDialog)
                    Box(
                        contentAlignment = Alignment.TopCenter, modifier = Modifier
                            .rotate(4f)
                            .fillMaxHeight()
                            .fillMaxWidth()
                    ) {
                        bodyContentExample()
                    }
                }
            }
        }
    }
}