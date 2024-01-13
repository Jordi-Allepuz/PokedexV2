package com.example.pokedexv2.pokedexappv2.domain.usecases


import com.example.pokedexv2.pokedexappv2.data.dataInfo.Pokemon
import com.example.pokedexv2.pokedexappv2.data.repositories.PokemonRepositoryImpl
import javax.inject.Inject

class GetPokemoUseCase @Inject constructor(private val repository: PokemonRepositoryImpl){

    suspend fun execute (nombrePokemon:String): Pokemon {
        return repository.getPokemonInfo(nombrePokemon)
    }

}