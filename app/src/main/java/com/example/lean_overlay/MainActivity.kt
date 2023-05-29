package com.example.lean_overlay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.foundation.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lean_overlay.ui.theme.LeanOverlayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeanOverlayTheme {
                // just an empty commit for making new beginnings
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    StackedCards()
                }
            }
        }
    }
}

@Composable
fun StackedCards() {
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
                color = Color.Black,
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
            backgroundColor = Color.Blue,
            shape = RoundedCornerShape(10.dp)
        ) {
            // Content of the card
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LeanOverlayTheme {
        StackedCards()
    }
}