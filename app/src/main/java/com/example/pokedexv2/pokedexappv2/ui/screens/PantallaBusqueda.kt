package com.example.pokedexv2.pokedexappv2.ui.screens

import android.view.RoundedCorner
import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
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
                .height(200.dp)
        )
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Buscar Pokemon") },
            singleLine = true,
            shape = CircleShape,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFDF594F),
                textColor = Color.Black
            )
        )
        Button(colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            onClick = {
                viewModel.catchPokemon(text)
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
