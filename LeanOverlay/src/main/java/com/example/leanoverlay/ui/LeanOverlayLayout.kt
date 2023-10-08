package com.example.leanoverlay.ui

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.leanoverlay.data.BorderLineCanvasParams
import com.example.leanoverlay.data.MainCardParams
import com.example.leanoverlay.helpers.DialogAnimation
import com.example.leanoverlay.helpers.createAnimatedModifier

@Composable
 fun LeanOverlayLayout(
    offsetAnimation: Dp,
    alphaAnimation: Float,
    showDialog: MutableState<Boolean>,
    animationDirection: DialogAnimation,
    modifier: Modifier = Modifier,
    withCloseIcon: Boolean,
    borderLineCanvasParams: BorderLineCanvasParams,
    mainCardParams: MainCardParams,
    bodyContentExample: @Composable () -> Unit,
) {
    val isVertical =
        animationDirection is DialogAnimation.TopToCenter || animationDirection is DialogAnimation.BottomToCenter
    val animatedModifier = createAnimatedModifier(isVertical, offsetAnimation, alphaAnimation)
    Box(
        animatedModifier
    ) {

        StackedCards(showDialog = showDialog, modifier, withCloseIcon, borderLineCanvasParams, mainCardParams){
            bodyContentExample()
        }
    }
}