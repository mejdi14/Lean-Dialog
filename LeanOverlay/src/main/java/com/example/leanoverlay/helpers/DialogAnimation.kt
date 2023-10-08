package com.example.leanoverlay.helpers

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.Dp

sealed class DialogAnimation(val value: Float) {
    object TopToCenter: DialogAnimation(-400f)
    object BottomToCenter: DialogAnimation(200f)
    object LeftToRight: DialogAnimation(-400f)
    object RightToLeft: DialogAnimation(400f)
    object NONE: DialogAnimation(0f)
}

fun createAnimatedModifier(
    isXAxis: Boolean,
    offsetAnimation: Dp,
    alphaAnimation: Float
): Modifier {
    return if (isXAxis) {
        Modifier
            .offset(x = offsetAnimation)
            .wrapContentSize()
            .alpha(alphaAnimation)
    } else {
        Modifier
            .fillMaxSize()
            .offset(y = offsetAnimation)
            .alpha(alphaAnimation)
    }
}





