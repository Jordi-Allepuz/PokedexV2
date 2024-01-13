package com.example.pokedexv2.pokedexappv2.data.sources.remote

import com.example.pokedexv2.pokedexappv2.data.dataInfo.Pokemon
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String
    ): Pokemon

}