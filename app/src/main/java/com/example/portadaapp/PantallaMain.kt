package com.example.portadaapp

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.content.res.Configuration.ORIENTATION_PORTRAIT
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
    fun PantallaMain(modifier: Modifier = Modifier, navController: NavHostController) {

    when (LocalConfiguration.current.orientation) {
        ORIENTATION_LANDSCAPE -> {
            Orientacion_Horizontal(modifier, navController)
        } ORIENTATION_PORTRAIT -> {
        Orientacion_Vertical(modifier, navController)
        } else -> {
            Orientacion_Vertical(modifier, navController)
        }
    }
}
    @Composable
    fun Orientacion_Vertical(modifier: Modifier, navController: NavHostController) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Magenta)
        ) {
            Text(
                text = "Main",
                fontSize = 50.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier
                .size(50.dp))

            val botones = mapOf("Play" to "PantallaPlay",
                "New Player" to "PantallaNewPlayer",
                "Preferences" to "PantallaOpciones",
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
        }
    }


    @Composable
    fun Orientacion_Horizontal(modifier: Modifier, navController: NavHostController) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color.Magenta),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Main",
                fontSize = 50.sp,
                modifier = Modifier
                    .fillMaxWidth(),
                color = Color.Magenta,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier
                .size(50.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .weight(2f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) { Text(text = "Play") }

                Button(
                    onClick = {navController.navigate("PantallaNewPlayer")},
                    modifier = Modifier
                        .weight(2f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) { Text(text = "New Player") }
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    modifier = Modifier
                        .weight(2f)
                ) { Text(text = "Preferences") }

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    modifier = Modifier
                        .weight(2f)
                ) { Text(text = "About") }
            }
        }
    }