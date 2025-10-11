package com.example.portadaapp

import android.content.Context
import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.content.res.Configuration.ORIENTATION_PORTRAIT
import android.graphics.drawable.Icon
import android.media.Rating
import android.transition.Slide
import android.widget.Toast
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavHostController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlin.contracts.contract
import kotlin.math.ceil
import kotlin.math.floor

@Composable
fun PantallaOpciones(modifier: Modifier = Modifier, navController: NavHostController) {

    val scrollState = rememberScrollState()

    when (LocalConfiguration.current.orientation) {
        ORIENTATION_LANDSCAPE -> {
            Orientacion_VerticalPO(modifier, navController, scrollState)
        }

        ORIENTATION_PORTRAIT -> {
            Orientacion_VerticalPO(modifier, navController, scrollState)
        }

        else -> {
            Orientacion_VerticalPO(modifier, navController, scrollState)
        }
    }
}

@Composable
fun Orientacion_VerticalPO(modifier: Modifier, navController: NavHostController, scrollState: ScrollState) {

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

    var ratingState by remember {
        mutableIntStateOf(0)
    }

    var plataformaSeleccionada by remember {
        mutableStateOf<String?>(null)
    }


    val context = LocalContext.current

    Box(
        modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
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

            SimpleDiscreteSlider()

            Column(modifier = Modifier
                .padding(
                    top = 20.dp,
                    start = 40.dp,
                    end = 15.dp)) {
                RatingBar(
                    rating = ratingState,
                    onRatingChanged = {
                            newRating -> ratingState = newRating
                    }
                )
            }

            Column(modifier = Modifier
                .padding(top = 15.dp)) {
                Text(
                    text = "Plataformas:"
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    val botonesChip = listOf("PS4", "XBOX", "3DS", "WII", "WIIu")
                    for (boton in botonesChip) {
                        FilterChipConsolas(boton,
                            plataformaSeleccionada == boton,
                            onChipSelected = { plataformaSeleccionada = boton },
                            context
                        )
                    }

                }
            }

        }

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
fun SimpleDiscreteSlider() {
    val range = 0.0f..10.0f
    val steps = 9
    var selection by remember { mutableStateOf(0f) }

    Slider(
        value = selection,
        valueRange = range,
        steps = steps,
        onValueChange = { selection = it }
    )
}

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Int = 0,
    stars: Int = 10,
    starsColors: Color = Color.Magenta,
    onRatingChanged: (Int) -> Unit = {}
) {
    Row(
        modifier = modifier
    ) {
        for (i in 1..stars) {
            val iconRating = if (i <= rating) {
                Icons.Filled.Favorite
            } else {
                Icons.Default.FavoriteBorder
            }
            Icon(
                imageVector = iconRating,
                contentDescription = null,
                tint = starsColors,
                modifier = modifier
                    .clickable{
                        onRatingChanged(i)
                    }
            )
        }
    }
}

@Composable
fun FilterChipConsolas(
    nombreChip: String,
    isSelected: Boolean,
    onChipSelected: () -> Unit,
    context: Context
) {
    var selected by remember {
        mutableStateOf(false)
    }

    FilterChip(
        onClick = {
                  if (!selected) {
                      onChipSelected()
                      Toast.makeText(context, "Has seleccionado $nombreChip", Toast.LENGTH_SHORT).show()
                  }
                  },
        label = {
            Text(
                text = nombreChip
            )
        },
        selected = isSelected,
        leadingIcon = if (isSelected) {
            {
                Icon(imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
    )
}