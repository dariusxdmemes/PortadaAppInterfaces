package com.example.portadaapp

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
    fun PantallaMain(modifier: Modifier = Modifier) {

    when (LocalConfiguration.current.orientation) {
        ORIENTATION_LANDSCAPE -> {
            Orientacion_Horizontal(modifier)
        } else -> {
            Orientacion_Vertical(modifier)
        }
    }
}
    @Composable
    fun Orientacion_Vertical(modifier: Modifier = Modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(-10.dp),
            modifier = Modifier.fillMaxSize()
                .wrapContentHeight()
        ) {
            Text(
                text = "Rentify",
                fontSize = 50.sp,
                modifier = modifier,
                color = Color.Magenta
            )

            Spacer(modifier = Modifier.size(50.dp))

            val botones = listOf("Play", "New Player", "Preferences", "About")
            for (i in botones) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    modifier = modifier
                        .width(200.dp)
                        .size(60.dp)
                ) {
                    Text(text = i)
                }
            }
        }
    }


    @Composable
    fun Orientacion_Horizontal(modifier: Modifier = Modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(-10.dp),
            modifier = modifier.fillMaxSize()
                .wrapContentHeight(),
        ) {
            Text(
                text = "Rentify",
                fontSize = 50.sp,
                modifier = modifier,
                color = Color.Magenta
            )

            //Spacer(modifier = Modifier.size(10.dp))

            Row {
                val botonesIzquierda = listOf("Play", "New Player")
                for (i in botonesIzquierda) {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                        modifier = modifier
                            .width(200.dp)
                            .height(60.dp)
                            //.size(50.dp)
                    ) {
                        Text(text = i)
                    }
                    Spacer(Modifier.size(50.dp))
                }
            }

            Row {
                val botonesDerecha = listOf("Preferences", "About")
                for (i in botonesDerecha) {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                        modifier = modifier
                            .width(200.dp)
                            .height(60.dp)
                            //.size(100.dp)
                    ) {
                        Text(text = i)
                    }
                    Spacer(Modifier.size(50.dp))
                }
            }
        }
    }