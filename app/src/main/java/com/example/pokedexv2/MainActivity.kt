package com.example.pokedexv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.pokedexv2.ui.theme.PokedexV2Theme
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

class MainActivity : ComponentActivity() {

    val viewModel by viewModels<PokemonViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexV2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Prueba(viewModel)
                }
            }
        }
    }
}


@OptIn(ExperimentalCoilApi::class)
@Composable
fun Prueba(viewModel: PokemonViewModel) {

    val pokemon: Pokemon? by viewModel.pokemon.observeAsState()


    if (pokemon == null) {
        CircularProgressIndicator()
    } else {
        Column (horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Nombre: ${pokemon!!.name}")
            Text(text = "ID: ${pokemon!!.id}")
            Text(text = "Peso: ${pokemon!!.height/10.0}")
            Text(text = "Altura: ${pokemon!!.weight/10.0}")
            pokemon!!.stats.forEach { stat ->
                Text(text = "${stat.stat.name}: ${stat.baseStat}")
            }
            pokemon!!.types.forEach { type ->
                Text(text = "Tipo: ${type.type.name}")
            }
            val pokemonImagen = pokemon?.sprites?.other?.officialArtwork?.frontDefault
            Text(text = pokemonImagen.toString())
            if (pokemonImagen == null){
                CircularProgressIndicator()
            }else{
                Image(
                    painter = rememberImagePainter(pokemonImagen),
                    contentDescription = "pokemonImagen",
                    modifier = Modifier.width(180.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}


interface PokeApi {
    companion object {
        val instance = Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build().create(PokeApi::class.java)
    }

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String
    ): Pokemon

}


interface PokemonRepository {
    suspend fun getPokemonInfo(nombrePokemon: String): Pokemon
}


class PokemonRepositoryImpl(private val api: PokeApi) : PokemonRepository {

    override suspend fun getPokemonInfo(nombrePokemon: String): Pokemon {
        return api.getPokemonInfo(nombrePokemon)
    }
}


class PokemonViewModel(private val repository: PokemonRepository = PokemonRepositoryImpl(PokeApi.instance)) :
    ViewModel() {

//    val pokemon = mutableStateOf<Pokemon?>(null)

    private val _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon> = _pokemon

    init {
        viewModelScope.launch {
            _pokemon.value = repository.getPokemonInfo("charizard")
        }
    }

}
