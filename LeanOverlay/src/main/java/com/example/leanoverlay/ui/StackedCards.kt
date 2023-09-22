package com.example.leanoverlay.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StackedCards(showDialog: MutableState<Boolean>, bodyContentExample: @Composable () -> Unit) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Canvas(
            modifier = Modifier
                .align(Alignment.Center)
                .width(300.dp)
                .height(200.dp) // Adjust size as needed
        ) {
            val strokeWidth = 2.dp.toPx()
            val cornerRadius = 10.dp.toPx()

            drawRoundRect(
                color = Color.White,
                topLeft = Offset.Zero,
                size = this.size,
                cornerRadius = CornerRadius(cornerRadius, cornerRadius),
                style = Stroke(width = strokeWidth)
            )
        }

        Card(
            modifier = Modifier
                .align(Alignment.Center)
                .width(300.dp)
                .height(200.dp)
                .rotate(-4f),
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

@Composable
private fun BodyContentComposable() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Stay on your business",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.Black
        )

        Text(
            text = "Sign up to insure that you don't miss any new updates and to receive a weekly news letter.",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Light,
            fontSize = 12.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = Color.Black,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .padding(all = 10.dp)
            ) {
                Text(
                    "Sign Up",
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    color = Color.White
                )
            }
            Box(
                modifier = Modifier
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .padding(all = 10.dp)
            ) {
                Text(
                    "Next Time",
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }
        }
    }
}