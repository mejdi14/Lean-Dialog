package com.example.leanoverlay.data

import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

data class DrawRoundRectParams(
    val color: Color = Color.White,
    val topLeft: Offset = Offset.Zero,
    val cornerRadius: CornerRadius = CornerRadius(10f, 10f),
    val strokeWidth: Float = 2f
)