package com.example.pokedexv2.pokedexappv2.data.dataInfo

import com.google.gson.annotations.SerializedName

data class GenerationI(
    @SerializedName("red-blue")
    val redBlue: RedBlue,
    val yellow: Yellow
)