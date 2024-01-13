package com.example.pokedexv2.pokedexappv2.data.dataInfo

import com.google.gson.annotations.SerializedName

data class Other(
    val home: Home,
    val showdown: Showdown,
    @SerializedName("dream_world")
    val dreamWorld: DreamWorld,
    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtwork
)