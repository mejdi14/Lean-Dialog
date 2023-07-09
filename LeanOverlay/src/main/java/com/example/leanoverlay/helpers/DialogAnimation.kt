package com.example.leanoverlay.helpers

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

sealed class DialogAnimation(val value: Float) {
    object TopToCenter: DialogAnimation(-400f)
    object BottomToCenter: DialogAnimation(200f)
    object LeftToRight: DialogAnimation(-400f)
    object RightToLeft: DialogAnimation(400f)
    object NONE: DialogAnimation(0f)
}

@Composable
fun Modifier.animatedOffset(
    showDialog: MutableState<Boolean>,
    axis: DialogAnimation
): Modifier {

    val offsetAnimation by animateDpAsState(
        targetValue = if (showDialog.value) 0.dp else (axis.value).dp,
        animationSpec = spring(stiffness = Spring.StiffnessVeryLow)
    )

    return offset(y = offsetAnimation)

}

fun createAnimatedModifier(
    isXAxis: Boolean,
    offsetAnimation: Dp,
    alphaAnimation: Float
): Modifier {
    return if (isXAxis) {
        Modifier
            .fillMaxSize()
            .offset(x = offsetAnimation)
            .alpha(alphaAnimation)
    } else {
        Modifier
            .fillMaxSize()
            .offset(y = offsetAnimation)
            .alpha(alphaAnimation)
    }
}





