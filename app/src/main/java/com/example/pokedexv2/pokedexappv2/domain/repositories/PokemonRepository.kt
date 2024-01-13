package com.example.pokedexv2.pokedexappv2.domain.repositories

import com.example.pokedexv2.pokedexappv2.data.dataInfo.Pokemon

interface PokemonRepository {
    suspend fun getPokemonInfo(nombrePokemon: String): Pokemon
}