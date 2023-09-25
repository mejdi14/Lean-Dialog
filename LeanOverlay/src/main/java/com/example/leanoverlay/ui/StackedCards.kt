package com.example.leanoverlay.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.example.leanoverlay.data.BorderLineCanvasParams
import com.example.leanoverlay.data.MainCardParams

@Composable
fun StackedCards(
    showDialog: MutableState<Boolean>,
    modifier: Modifier,
    withCloseIcon: Boolean,
    borderLineCanvasParams: BorderLineCanvasParams,
    mainCardParams: MainCardParams,
    bodyContentExample: @Composable () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.then(Modifier.padding(top = 10.dp, bottom = 10.dp))
    ) {
        Canvas(
            modifier = modifier.then(
                Modifier
                    .align(Alignment.Center)
            )
        ) {
            val size = this.size

            with(borderLineCanvasParams) {
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
            modifier = modifier.then(
                Modifier
                    .align(Alignment.Center)
                    .rotate(mainCardParams.rotationAngle)
            ),
            backgroundColor = mainCardParams.backgroundColor,
            shape = mainCardParams.roundedCornerShape
        ) {
            Box(contentAlignment = Alignment.TopEnd, modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp, end = 5.dp, top = 5.dp)
                ) {
                    if (withCloseIcon)
                        CloseIconComposable(showDialog)
                    Box(
                        contentAlignment = Alignment.TopCenter, modifier = Modifier
                            .rotate(-(mainCardParams.rotationAngle))
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
