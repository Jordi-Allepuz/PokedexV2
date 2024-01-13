package com.example.pokedexv2.pokedexappv2.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedexv2.pokedexappv2.data.dataInfo.Pokemon
import com.example.pokedexv2.pokedexappv2.ui.components.Cabecera
import com.example.pokedexv2.pokedexappv2.ui.components.PesoAltura
import com.example.pokedexv2.pokedexappv2.ui.components.Stats
import com.example.pokedexv2.pokedexappv2.ui.components.Tipos
import com.example.pokedexv2.pokedexappv2.ui.viewmodels.PokemonViewModel


@Composable
fun PokemonPantallaFicha(
    viewModel: PokemonViewModel
) {

//    val pokemon = viewModel.pokemon.value!!
    val pokemon: Pokemon? by viewModel.pokemon.observeAsState()


    if (pokemon == null) {
        CircularProgressIndicator()
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF272727)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Cabecera(pokemon = pokemon!!)
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
            )
            Text(
                text = pokemon!!.name,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                modifier = Modifier.padding(10.dp)
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )
            Tipos(pokemon = pokemon!!)
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(25.dp)
            )
            PesoAltura(pokemon = pokemon!!)
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
            )
            Text(
                text = "Base Stats",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier.padding(4.dp)
            )
            Stats(pokemon = pokemon!!)
        }
    }
}


















