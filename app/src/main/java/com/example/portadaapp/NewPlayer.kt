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
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun PantallaNewPlayer(modifier: Modifier = Modifier, navController: NavHostController) {

    when (LocalConfiguration.current.orientation) {
        ORIENTATION_LANDSCAPE -> {
            Orientacion_HorizontalNP(modifier, navController)
        } else -> {
        Orientacion_VerticalNP(modifier, navController)
    }
    }
}
@Composable
fun Orientacion_VerticalNP(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(-10.dp),
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight()
    ) {
        Text(
            text = "New player",
            fontSize = 50.sp,
            color = Color.Magenta
        )

        Spacer(modifier = Modifier.size(50.dp))

        val botones = mapOf("Play" to "PantallaPlay",
            "New Player" to "PantallaNewPlayer",
            "Preferences" to "PantallaPreferences",
            "About" to "PantallaAbout")

        botones.forEach { (nombre, ruta) ->
            Button(
                onClick = { navController.navigate(ruta) },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                modifier = Modifier
                    .width(200.dp)
                    .height(60.dp)
            ) {
                Text(text = nombre)
            }
        }

//            val botones = listOf("Play", "New Player", "Preferences", "About")
//            for (i in botones) {
//                Button(
//                    onClick = {navController.navigate(i)},
//                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
//                    modifier = modifier
//                        .width(200.dp)
//                        .size(60.dp)
//                ) {
//                    Text(text = i)
//                }
//            }
    }
}


@Composable
fun Orientacion_HorizontalNP(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(-10.dp),
        modifier = modifier.fillMaxSize()
            .wrapContentHeight(),
    ) {
        Text(
            text = "New player",
            fontSize = 50.sp,
            modifier = modifier,
            color = Color.Magenta
        )

        Spacer(modifier = Modifier.size(10.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            val botonesIzquierda = mapOf(
                "Play" to "Play",
                "New Player" to "PantallaNewPlayer"
            )
            botonesIzquierda.forEach { (nombre, ruta) ->
                Button(
                    onClick = { navController.navigate(ruta) },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    modifier = Modifier
                        .width(180.dp)
                        .height(60.dp)
                ) {
                    Text(text = nombre)
                }
            }
        }
        Spacer(Modifier.size(50.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            val botonesDerecha = mapOf(
                "Preferences" to "Preferences",
                "About" to "About"
            )

            botonesDerecha.forEach { (nombre, ruta) ->
                Button(
                    onClick = { navController.navigate(ruta) },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    modifier = Modifier
                        .width(180.dp)
                        .height(60.dp)
                ) {
                    Text(text = nombre)
                }
            }
        }
    }
}