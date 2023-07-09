package com.example.lean_overlay.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
 fun BodyContentExample() {
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