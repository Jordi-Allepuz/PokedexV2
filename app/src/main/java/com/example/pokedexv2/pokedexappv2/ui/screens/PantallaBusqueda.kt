package com.example.pokedexv2.pokedexappv2.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pokedexv2.R
import com.example.pokedexv2.Routes
import com.example.pokedexv2.pokedexappv2.ui.viewmodels.PokemonViewModel
import com.example.pokedexv2.ui.theme.pokemontipografi



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaBusqueda(viewModel: PokemonViewModel, navigationController: NavHostController) {
    var text by remember { mutableStateOf("") }

    Image(
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
        painter = painterResource(id = R.drawable.pokeball),
        contentDescription = ""
    )
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Buscar Pokemon") },
            singleLine = true,
            shape = CircleShape,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFF77F76),
                textColor = Color.Black,
            )
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )
        Button(colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE22A1C)),
            onClick = {
                viewModel.catchPokemon(text.lowercase())
                navigationController.navigate(Routes.PokemonFicha.route)
            }) {
            Text(
                "BUSCAR POKEMON",
                fontFamily = pokemontipografi,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Yellow
            )
        }
    }
}
