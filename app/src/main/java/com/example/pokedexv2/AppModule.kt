package com.example.pokedexv2

import android.app.Application
import android.content.Context
import com.example.pokedexv2.pokedexappv2.data.repositories.PokemonRepositoryImpl
import com.example.pokedexv2.pokedexappv2.data.sources.remote.PokemonApi
import com.example.pokedexv2.pokedexappv2.domain.repositories.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

//    @Provides
//    @Singleton
//    fun providePokemonApi(): PokemonApi = Retrofit.Builder()
//        .baseUrl("https://pokeapi.co/api/v2/")
//        .addConverterFactory(MoshiConverterFactory.create())
//        .client(OkHttpClient.Builder().build())
//        .build()
//        .create(PokemonApi::class.java)

    @Singleton @Provides
    fun providePokemonApi(): PokemonApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://pokeapi.co/api/v2/")
            .build()
            .create(PokemonApi::class.java)
    }


    @Provides
    @Singleton
    fun providePokemonRepository(api: PokemonApi): PokemonRepository {
        return PokemonRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideApplicationContext(app: Application): Context = app
}