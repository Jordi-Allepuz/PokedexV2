package com.example.pokedexv2.pokedexappv2.domain.models

import com.example.pokedexv2.pokedexappv2.data.dataInfo.Stat
import com.example.pokedexv2.pokedexappv2.data.dataInfo.Type


data class Pokemon (
    val id: Int,
    val name: String,
    val imageURL: String,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int,
    val height: Int
)
