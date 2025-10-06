package com.example.portadaapp

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.content.res.Configuration.ORIENTATION_PORTRAIT
import android.transition.Slide
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavHostController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlin.math.ceil
import kotlin.math.floor

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

    var sliderPosition by remember {
        mutableStateOf(0f)
    }

    var sliderState by rememberSaveable {
        mutableStateOf("No has seleccionado nada!")
    }

    val context = LocalContext.current

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

            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it },
                Modifier.padding(20.dp),
                colors = SliderDefaults.colors(
                    thumbColor = MaterialTheme.colorScheme.secondary,
                    activeTickColor = MaterialTheme.colorScheme.secondary,
                    inactiveTickColor = MaterialTheme.colorScheme.secondaryContainer,
                ),
                steps = 9,
                valueRange = 0f..10f
            )



        }

        Spacer(
            modifier = Modifier
                .size(10.dp)
        )

        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 16.dp,
                    bottom = 16.dp),
            onClick = {
                Toast.makeText(context,"Has seleccionado $selectedOption con una puntuacion de ${sliderPosition.toInt()}",
                    Toast.LENGTH_LONG).show()
            }
        ) {
            Icon(Icons.Filled.Add, "FAB prueba")
        }

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

@Composable
fun RatingBar(
    modifier: Modifier,
    rating: Double = 0.0,
    stars: Int = 10,
    starsColor: Color = Color.Yellow
) {

    val filledStars = floor(rating).toInt()
    val unfilledStars = (stars - ceil(rating)).toInt()
    val halfStar = !(rating.rem(1).equals(0.0))

    Row(
        modifier = modifier
    ) {
        repeat(filledStars) {
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = null, tint = starsColor
            )
        }

        if (halfStar) {
            Icon(
                imageVector = Icons.Outlined.Close,
                contentDescription = null,
                tint = starsColor
            )
        }
    }
}