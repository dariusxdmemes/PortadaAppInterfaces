package com.example.portadaapp

import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource

data class CheckInfo(val title: String,
                     var isSelected: Boolean,
                     var onCheckedChange: (Boolean) -> Unit
)

data class Juego(
    val nombreJuego: String,
    val rutaImagenJuego: Int,
    val descripcionImagen: String
)

@Composable
fun PantallaPlay(modifier: Modifier, navController: NavHostController) {

    var juegosSeleccioandos by remember {
        mutableStateOf(listOf(
            Juego("Angry birds", R.drawable.games_angrybirds, "imagen_angrybirds"),
            Juego("Dragon Fly", R.drawable.games_dragonfly, "imagen_dragonfly"),
            Juego("Hill Climbing Racing", R.drawable.games_hillclimbingracing, "imagen_hillclimbing"),
            Juego("Radiant Defense", R.drawable.games_radiantdefense, "imagen_radiantdef"),
            Juego("Pocket Soccer", R.drawable.games_pocketsoccer, "imagen_soccer"),
            Juego("Ninja Jump", R.drawable.games_ninjump, "imagen_ninjump"),
            Juego("Air Control", R.drawable.games_aircontrol, "imagen_aircontrol")
        ).associateWith {
            false
        }
        )
    }

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
        ) {
            crearFilasBotones(
                juegosSeleccioandos = juegosSeleccioandos,
                onCheckedChange = { juego, isChecked ->
                    juegosSeleccioandos = juegosSeleccioandos.toMutableMap().apply {
                        this[juego] = isChecked
                    }
                }
            )
        }
        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(
                    end = 16.dp,
                    bottom = 16.dp
                ),
            onClick = {
                val elegidos = juegosSeleccioandos.filter { it.value }.keys
                val nombres = elegidos.joinToString(", ") { it.nombreJuego }

                Toast.makeText(
                    context,
                    if (nombres.isEmpty()) {
                        "No se ha seleccionado nada!"
                    } else {
                        "Has seleccionado $nombres"
                    },
                    Toast.LENGTH_SHORT
                ).show()
            },
            containerColor = Color.Yellow
        ) {
            Icon(Icons.Filled.Done, "FAB prueba")
        }
    }
}

@Composable
fun crearFilasBotones(
    juegosSeleccioandos: Map<Juego, Boolean>,
                      onCheckedChange: (Juego, Boolean) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        juegosSeleccioandos.forEach { (juego, checked) ->
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CrearImagenes(juego.rutaImagenJuego, juego.descripcionImagen)
                CheckBoxMinimal(juego.nombreJuego,
                    checked = checked,
                    onCheckedChange = { onCheckedChange(juego, it) }
                )
            }
            Spacer(
                modifier = Modifier
                    .size(10.dp)
            )

        }
    }

}

@Composable
fun CheckBoxMinimal(
    nombreCheckbox: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
    ) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        Text(
            text = nombreCheckbox
        )
    }
}

@Composable
fun CrearImagenes(rutaImagenes: Int, descripcionImagen: String) {
    Image(
        painter = painterResource(id = rutaImagenes),
        contentDescription = descripcionImagen,
        modifier = Modifier
            .size(50.dp)
    )
}