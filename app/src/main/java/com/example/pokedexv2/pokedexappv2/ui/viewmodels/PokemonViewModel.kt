package com.example.pokedexv2.pokedexappv2.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexv2.pokedexappv2.domain.models.Pokemon
import com.example.pokedexv2.pokedexappv2.domain.usecases.GetPokemoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PokemonViewModel @Inject constructor  ( private val getPokemoUseCase: GetPokemoUseCase) :
    ViewModel() {


    private val _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon> = _pokemon


    fun catchPokemon(pokemonName: String) {
        viewModelScope.launch {
            _pokemon.value = getPokemoUseCase.execute(pokemonName)
        }
    }

}