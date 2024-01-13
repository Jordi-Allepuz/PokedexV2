//package com.example.pokedexv2.pokedexappv2.ui.screens
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.material3.Button
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.livedata.observeAsState
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.navigation.NavHostController
//import com.example.pokedexv2.Routes
//import com.example.pokedexv2.pokedexappv2.data.dataInfo.Pokemon
//import com.example.pokedexv2.pokedexappv2.ui.viewmodels.PokemonViewModel
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun PokemonSearchScreen(viewModel: PokemonViewModel, navigationController: NavHostController) {
//    var nombrePokemon by remember { mutableStateOf("") }
//
//
//    Column {
//        TextField(
//            value = nombrePokemon,
//            onValueChange = { nombrePokemon = it },
//            label = { Text("Nombre del Pokémon") }
//        )
//        Button(onClick = {navigationController.navigate(Routes.PokemonFicha.route) }) {
//            Text("Buscar Pokémon")
//        }
//    }
//}