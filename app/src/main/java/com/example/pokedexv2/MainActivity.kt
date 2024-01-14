package com.example.pokedexv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedexv2.pokedexappv2.ui.screens.PantallaBusqueda
import com.example.pokedexv2.pokedexappv2.ui.screens.PokemonPantallaFicha
import com.example.pokedexv2.pokedexappv2.ui.viewmodels.PokemonViewModel
import com.example.pokedexv2.ui.theme.PokedexV2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel by viewModels<PokemonViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexV2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.PokemonBusqueda.route
                    ) {
                        composable(Routes.PokemonBusqueda.route) {
                            PantallaBusqueda(viewModel,navigationController)
                        }
                        composable(Routes.PokemonFicha.route) {
                            PokemonPantallaFicha(viewModel, navigationController)
                        }
                    }
                }
            }
        }
    }
}










