package com.example.pokedexv2.pokedexappv2.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexv2.pokedexappv2.data.dataInfo.Pokemon
import com.example.pokedexv2.pokedexappv2.data.repositories.PokemonRepositoryImpl
import com.example.pokedexv2.pokedexappv2.data.sources.remote.PokemonApi
import com.example.pokedexv2.pokedexappv2.domain.repositories.PokemonRepository
import com.example.pokedexv2.pokedexappv2.domain.usecases.GetPokemoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PokemonViewModel @Inject constructor  ( private val getPokemoUseCase: GetPokemoUseCase) :
    ViewModel() {

//    val pokemon = mutableStateOf<Pokemon?>(null)

    private val _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon> = _pokemon

    init {
        viewModelScope.launch {
            _pokemon.value = getPokemoUseCase.execute("pikachu")
        }
    }

}