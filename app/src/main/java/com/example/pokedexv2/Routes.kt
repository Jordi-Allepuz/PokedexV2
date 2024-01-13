//package com.example.pokedexv2
//
//sealed class Routes(val route:String){
//    object PokemonFicha:Routes("pokemonficha")
//    object PokemonSearch:Routes("pokemonsearch/{nombrePokemon}"){
//        fun createRoute(nombrePokemon:String)= "pokemonsearch/$nombrePokemon"
//    }
//}