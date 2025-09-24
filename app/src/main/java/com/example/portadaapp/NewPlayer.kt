package com.example.portadaapp

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.content.res.Configuration.ORIENTATION_PORTRAIT
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun PantallaNewPlayer(modifier: Modifier = Modifier, navController: NavHostController) {

    when (LocalConfiguration.current.orientation) {
        ORIENTATION_LANDSCAPE -> {
            Orientacion_VerticalNP(modifier, navController)
        }

        ORIENTATION_PORTRAIT -> {
            Orientacion_VerticalNP(modifier, navController)
        }

        else -> {
            Orientacion_VerticalNP(modifier, navController)
        }
    }
}
@Composable
fun Orientacion_VerticalNP(modifier: Modifier = Modifier, navController: NavHostController) {
 Column(
     horizontalAlignment = Alignment.CenterHorizontally,
     verticalArrangement = Arrangement.Center,
     modifier = modifier
         .fillMaxSize()
         .background(Color.Magenta)
         .verticalScroll(
             rememberScrollState()
         )
 ) {
     Row(
         modifier = Modifier
             .fillMaxWidth(1f)
     ) {
         Image(
             painter = painterResource(id = R.drawable.account),
             contentDescription = "imagen_cuenta",
             modifier = Modifier
                 .size(50.dp)
         )

         var estadoTextFieldNombre by remember {
             mutableStateOf(" ")
         }

         TextField(
             value = estadoTextFieldNombre,
             onValueChange = {
                 estadoTextFieldNombre = it
             }, label = {
                 Text(text = "Nombre")
             }
         )

     }

     Spacer(
         modifier = Modifier
             .size(10.dp)
     )

     Row(
         modifier = Modifier
             .fillMaxWidth(1f)
     ) {

         Spacer(
             modifier = Modifier
                 .size(50.dp)
         )

         var estadoTextFieldApellidos by remember {
             mutableStateOf(" ")
         }

         TextField(
             value = estadoTextFieldApellidos,
             onValueChange = {
                 estadoTextFieldApellidos = it
             }, label = {
                 Text(text = "Apellidos")
             }
         )
     }

     Spacer(
         modifier = Modifier
             .size(10.dp)
     )

     Row(
         modifier = Modifier
             .fillMaxWidth(1f)
     ) {
         Spacer(
             modifier = Modifier
                 .size(50.dp)
         )

         var estadoTextFieldNick by remember {
             mutableStateOf(" ")
         }

         TextField(
             value = estadoTextFieldNick,
             onValueChange = {
                 estadoTextFieldNick = it
             }, label = {
                 Text(text = "Nickname")
             }
         )
     }

     Spacer(
         modifier = Modifier
             .size(10.dp)
     )

     Row(
         verticalAlignment = Alignment.CenterVertically,
         horizontalArrangement = Arrangement.Center,
         modifier = Modifier
             .fillMaxWidth(1f)
     ) {
         Image(
             painter = painterResource(id = R.drawable.android),
             contentDescription = "imagen_android",
             modifier = Modifier
                 .size(60.dp)
         )

         Spacer(
             modifier = Modifier
                 .width(15.dp)
         )

         Button(
             onClick = {}
         ) {
             Text(text = "Change")
         }
     }

     Spacer(
         modifier = Modifier
             .size(10.dp)
     )

     Row(modifier = Modifier
         .fillMaxWidth(1f)
     ) {
         Image(
             painter = painterResource(id = R.drawable.camera),
             contentDescription = "imagen_camara",
             modifier = Modifier
                 .size(50.dp)
         )

         var estadoTextFieldCamara by remember {
             mutableStateOf(" ")
         }

         TextField(
             value = estadoTextFieldCamara,
             onValueChange = {
                 estadoTextFieldCamara = it
             }, label = {
                 Text(text = "Teléfono")
             }
         )
     }

     Spacer(
         modifier = Modifier
             .size(10.dp)
     )

     Row(modifier = Modifier
         .fillMaxWidth(1f)
     ) {
         Image(
             painter = painterResource(id = R.drawable.email),
             contentDescription = "imagen_email",
             modifier = Modifier
                 .size(50.dp)
         )

         var estadoTextFieldEmail by remember {
             mutableStateOf(" ")
         }

         TextField(
             value = estadoTextFieldEmail,
             onValueChange = {
                 estadoTextFieldEmail = it
             }, label = {
                 Text(text = "Email")
             }
         )
     }

     Spacer(
         modifier = Modifier
             .size(10.dp)
     )

     Row(
         verticalAlignment = Alignment.CenterVertically,
         horizontalArrangement = Arrangement.Center,
         modifier = Modifier
             .fillMaxWidth(1f)
     ) {
         Button(
             onClick = {}
         ) {
             Text(text = "New player")
         }
     }
 }
}


@Composable
fun Orientacion_HorizontalNP(modifier: Modifier = Modifier, navController: NavHostController) {
// Funcion vista landscape
}