package com.example.leanoverlay

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.leanoverlay.helpers.DialogAnimation
import com.example.leanoverlay.ui.LeanOverlayLayout

@Composable
fun LeanOverlay(
    showDialog: MutableState<Boolean>,
    offsetAnimation: Dp,
    alphaAnimation: Float,
    dismissOnClickOutside: Boolean = true,
    modifier: Modifier = Modifier,
    bodyContentExample: @Composable () -> Unit
) {
    Dialog(
        onDismissRequest = { showDialog.value = false },
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = dismissOnClickOutside
        )
    ) {
        LeanOverlayLayout(
            offsetAnimation,
            alphaAnimation,
            showDialog,
            DialogAnimation.BottomToCenter,
            modifier
        ){
            bodyContentExample()
        }
    }
}