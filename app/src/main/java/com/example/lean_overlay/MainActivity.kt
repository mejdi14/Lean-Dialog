package com.example.lean_overlay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
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
                    val showDialog = remember { mutableStateOf(false) }

                    Button(onClick = { showDialog.value = true }) {
                        Text("Show Dialog")
                    }

                    if (showDialog.value) {
                        Dialog(
                            onDismissRequest = { showDialog.value = false },
                            properties = DialogProperties(
                                dismissOnBackPress = true,
                                dismissOnClickOutside = true
                            )
                        ) {
                            StackedCards()
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun StackedCards() {
        Box(contentAlignment = Alignment.Center) {
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
                        CloseIconComposable()
                        Box(
                            contentAlignment = Alignment.TopCenter, modifier = Modifier
                                .rotate(4f)
                                .fillMaxHeight()
                                .fillMaxWidth()
                        ) {
                            BodyContentComposable()
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

    @Composable
    private fun CloseIconComposable() {
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

                    }
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        LeanOverlayTheme {
            StackedCards()
        }
    }
}