package com.example.portadaapp

import PantallaSplash
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.portadaapp.ui.theme.PortadaAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PortadaAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "PantallaSplash",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("PantallaMain") {
                            PantallaMain(
                                modifier = Modifier.fillMaxSize(),
                                navController = navController
                            )
                        }
                        composable("PantallaNewPlayer") {
                            PantallaNewPlayer(
                                modifier = Modifier.fillMaxSize(),
                                navController = navController
                            )
                        }
                        composable("PantallaOpciones") {
                            PantallaOpciones(
                                modifier = Modifier.fillMaxSize(),
                                navController = navController
                            )
                        }
                        composable("PantallaPlay") {
                            PantallaPlay(
                                modifier = Modifier.fillMaxSize(),
                                navController = navController
                            )
                        }
                        composable("PantallaSplash") {
                            PantallaSplash(
                                modifier = Modifier.fillMaxSize(),
                                navController = navController
                            )
                        }
//                        composable("PantallaAbout") {
//                            PantallaAbout(
//                                modifier = Modifier.fillMaxSize(),
//                                navController = navController
//                            )
//                        }
                    }
                }
            }
        }
    }
}
