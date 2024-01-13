package com.example.pokedexv2

import android.app.Application
import android.content.Context
import com.example.pokedexv2.pokedexappv2.data.repositories.PokemonRepositoryImpl
import com.example.pokedexv2.pokedexappv2.data.sources.remote.PokemonApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{


    @Provides
    @Singleton
    fun providePokemonRepository(dataSource: PokemonApi): PokemonRepositoryImpl {
        return PokemonRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun provideApplicationContext(app: Application): Context = app
}