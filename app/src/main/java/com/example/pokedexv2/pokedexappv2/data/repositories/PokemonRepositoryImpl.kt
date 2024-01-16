package com.example.pokedexv2.pokedexappv2.data.repositories


import com.example.pokedexv2.pokedexappv2.data.mappers.DTOToModel
import com.example.pokedexv2.pokedexappv2.data.sources.remote.PokemonApi
import com.example.pokedexv2.pokedexappv2.domain.models.Pokemon
import com.example.pokedexv2.pokedexappv2.domain.repositories.PokemonRepository
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject



@ActivityScoped
class PokemonRepositoryImpl@Inject constructor(private val api: PokemonApi) :PokemonRepository{

    override suspend fun getPokemonInfo(nombrePokemon: String): Pokemon {
        var pokemonDTO = api.getPokemonInfo(nombrePokemon)
        return DTOToModel(pokemonDTO)
    }
}