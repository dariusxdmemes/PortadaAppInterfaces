package com.example.portadaapp

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.content.res.Configuration.ORIENTATION_PORTRAIT
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavHostController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun PantallaOpciones(modifier: Modifier = Modifier, navController: NavHostController) {
    when (LocalConfiguration.current.orientation) {
        ORIENTATION_LANDSCAPE -> {
            Orientacion_VerticalPO(modifier, navController)
        }

        ORIENTATION_PORTRAIT -> {
            Orientacion_VerticalPO(modifier, navController)
        }

        else -> {
            Orientacion_VerticalPO(modifier, navController)
        }
    }
}

@Composable
fun Orientacion_VerticalPO(modifier: Modifier, navController: NavHostController) {

    // VARIABLES DE CONTROL DE ESTADO DE RADIO BUTTONS

    var selectedOption by remember {
        mutableStateOf("")
    }

    Box(
        modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "Elige una opcion:",
            )

            crearBotonesPantalla(selectedOption) {
                selectedOption = it
            }
        }

        Spacer(
            modifier = Modifier
                .size(10.dp)
        )
    }
}

@Composable
fun crearBotonesPantalla(selectedOption: String, onItemSelected: (String) -> Unit) {
    val opciones = listOf(
        "Angry Birds", "Dragon Fly", "Hill Climbing",
        "Pocket Soccer", "Radiant Defense", "Ninja Jump",
        "Air Control"
    )

    opciones.forEach { opcion ->
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selectedOption == opcion,
                onClick = { onItemSelected(opcion) }
            )
            Text(
                text = opcion,
                modifier = Modifier
                    .padding(top = 12.dp)
            )
        }
    }
}