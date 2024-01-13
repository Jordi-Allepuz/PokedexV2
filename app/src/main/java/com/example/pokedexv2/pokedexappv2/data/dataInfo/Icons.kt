package com.example.pokedexv2.pokedexappv2.data.dataInfo

import com.google.gson.annotations.SerializedName

data class Icons(
    @SerializedName("front_default")
    val frontDefault: String,
    @SerializedName("front_female")
    val frontFemale: Any
)