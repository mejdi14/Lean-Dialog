package com.example.leanoverlay.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.unit.Dp
import com.example.leanoverlay.helpers.DialogAnimation
import com.example.leanoverlay.helpers.createAnimatedModifier

@Composable
 fun LeanOverlayLayout(
    offsetAnimation: Dp,
    alphaAnimation: Float,
    showDialog: MutableState<Boolean>,
    animationDirection: DialogAnimation,
    bodyContentExample: @Composable () -> Unit,
) {
    val isVertical =
        animationDirection is DialogAnimation.TopToCenter || animationDirection is DialogAnimation.BottomToCenter
    val animatedModifier = createAnimatedModifier(isVertical, offsetAnimation, alphaAnimation)
    Box(
        animatedModifier
    ) {

        StackedCards(showDialog = showDialog){
            bodyContentExample()
        }
    }
}