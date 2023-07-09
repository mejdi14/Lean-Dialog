package com.example.lean_overlay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lean_overlay.ui.layout.BodyContentExample
import com.example.lean_overlay.ui.theme.LeanOverlayTheme
import com.example.leanoverlay.LeanOverlay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeanOverlayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val showDialog = remember { mutableStateOf(false) }


                    val alphaAnimation by animateFloatAsState(
                        targetValue = if (showDialog.value) 1f else 0f
                    )

                    val offsetAnimation by animateDpAsState(
                        targetValue = if (showDialog.value) 0.dp else (DialogAnimation.BottomToCenter.value).dp,
                        animationSpec = spring(stiffness = Spring.StiffnessVeryLow)
                    )

                    Button(onClick = { showDialog.value = true }) {
                        Text("Show Dialog")
                    }

                    if (showDialog.value) {
                        LeanOverlay(showDialog, offsetAnimation, alphaAnimation, BodyContentExample())
                    }
                }
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        LeanOverlayTheme {

        }
    }
}