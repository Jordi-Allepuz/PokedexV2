package com.example.pokedexv2.pokedexappv2.data.dataInfo

import com.google.gson.annotations.SerializedName

data class GameIndice(
    @SerializedName("game_index")
    val gameIndex: Int,
    val version: Version
)