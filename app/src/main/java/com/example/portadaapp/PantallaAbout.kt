package com.example.portadaapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import com.example.portadaapp.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun PantallaAbout(modifier: Modifier, navController: NavHostController) {

    val personaSeleccionada by remember {
        mutableStateOf(listOf(
            Persona(
                "María Mata",
                2014,
                R.drawable.image1
            ),
            Persona(
                "Antonio Sanz",
                2056,
                R.drawable.image2
            ),
            Persona(
                "Carlos Perez",
                5231,
                R.drawable.image3
            ),
            Persona(
                "Beatriz Martos",
                1892,
                R.drawable.image4
            ),
            Persona(
                "Sandra Alegre",
                3400,
                R.drawable.image5
            ),
            Persona(
                "Alex Serrat",
                5874,
                R.drawable.image6
            ),
            Persona(
                "Ana Peris",
                2238,
                R.drawable.image7
            ),
            Persona(
                "Pablo Morralla",
                6969,
                R.drawable.image8
            )
        ))
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(personaSeleccionada.size) { index ->
            CrearRowFotosNombres(personaSeleccionada[index])
        }
    }

}

@Composable
fun CrearRowFotosNombres(persona: Persona) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = persona.imagen_persona),
            contentDescription = "Imagen por defecto",
            modifier = Modifier
                .size(100.dp)
                .padding(start = 10.dp)
        )

        Column {
            Text(
                text = persona.nombre_persona,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Puntos: ${persona.puntos_persona}"
            )
        }
    }
}