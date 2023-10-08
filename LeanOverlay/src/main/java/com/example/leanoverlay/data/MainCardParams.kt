package com.example.leanoverlay.data

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class MainCardParams (
    val backgroundColor: Color = Color.White,
    val roundedCornerShape: RoundedCornerShape = RoundedCornerShape(10.dp),
    val rotationAngle : Float = -4f
)