package com.example.pokedexv2.pokedexappv2.data.dataInfo

import com.google.gson.annotations.SerializedName

data class HeldItem(
    val item: Item,
    @SerializedName("version_details")
    val versionDetails: List<VersionDetail>
)