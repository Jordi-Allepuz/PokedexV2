package com.example.pokedexv2.pokedexappv2.ui.components

import androidx.compose.ui.graphics.Color
import com.example.pokedexv2.pokedexappv2.data.dataInfo.Stat
import com.example.pokedexv2.pokedexappv2.data.dataInfo.Type
import com.example.pokedexv2.ui.theme.agua
import com.example.pokedexv2.ui.theme.ataque
import com.example.pokedexv2.ui.theme.ataqueEspecial
import com.example.pokedexv2.ui.theme.bixo
import com.example.pokedexv2.ui.theme.defensa
import com.example.pokedexv2.ui.theme.defensaEspecial
import com.example.pokedexv2.ui.theme.dragon
import com.example.pokedexv2.ui.theme.electrico
import com.example.pokedexv2.ui.theme.fantasma
import com.example.pokedexv2.ui.theme.fuego
import com.example.pokedexv2.ui.theme.hada
import com.example.pokedexv2.ui.theme.hielo
import com.example.pokedexv2.ui.theme.hierba
import com.example.pokedexv2.ui.theme.hp
import com.example.pokedexv2.ui.theme.lucha
import com.example.pokedexv2.ui.theme.metal
import com.example.pokedexv2.ui.theme.normal
import com.example.pokedexv2.ui.theme.oscuro
import com.example.pokedexv2.ui.theme.psiquico
import com.example.pokedexv2.ui.theme.roca
import com.example.pokedexv2.ui.theme.tierra
import com.example.pokedexv2.ui.theme.velocidad
import com.example.pokedexv2.ui.theme.veneno
import com.example.pokedexv2.ui.theme.volador
import java.util.Locale

fun abreviaturasEstados(stat: Stat): String {
    return when (stat.stat.name.lowercase()) {
        "hp" -> "HP"
        "attack" -> "Atk"
        "defense" -> "Def"
        "special-attack" -> "SpAtk"
        "special-defense" -> "SpDef"
        "speed" -> "Spd"
        else -> ""
    }
}

fun estadosColores(stat: Stat): Color {
    return when (stat.stat.name.lowercase()) {
        "hp" -> hp
        "attack" -> ataque
        "defense" -> defensa
        "special-attack" -> ataqueEspecial
        "special-defense" -> defensaEspecial
        "speed" -> velocidad
        else -> Color.White
    }
}


fun tipoColores(type: Type): Color {
    return when (type.type.name.lowercase(Locale.ROOT)) {
        "normal" -> normal
        "fire" -> fuego
        "water" -> agua
        "electric" -> electrico
        "grass" -> hierba
        "ice" -> hielo
        "fighting" -> lucha
        "poison" -> veneno
        "ground" -> tierra
        "flying" -> volador
        "psychic" -> psiquico
        "bug" -> bixo
        "rock" -> roca
        "ghost" -> fantasma
        "dragon" -> dragon
        "dark" -> oscuro
        "steel" -> metal
        "fairy" -> hada
        else -> Color.Black
    }
}