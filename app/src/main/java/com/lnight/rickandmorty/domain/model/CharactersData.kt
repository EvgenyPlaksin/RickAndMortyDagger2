package com.lnight.rickandmorty.domain.model


data class CharactersData(
    val id: Int = -1,
    val name: String,
    val image: String,
    val gender: String,
    val cityName: String,
    val status: Boolean?,
    val species: String,
    val locationUrl: String
)
