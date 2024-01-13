package com.example.pokedexv2

sealed class Routes(val route:String){
    object PokemonFicha:Routes("pokemonficha")
    object PokemonBusqueda:Routes("pokemonbusqueda")
}