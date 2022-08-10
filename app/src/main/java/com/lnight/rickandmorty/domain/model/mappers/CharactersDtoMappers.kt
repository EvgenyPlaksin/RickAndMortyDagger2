package com.lnight.rickandmorty.domain.model.mappers

import com.lnight.rickandmorty.data.remote.dto.CharactersListResponseDto
import com.lnight.rickandmorty.data.remote.dto.Character
import com.lnight.rickandmorty.domain.model.CharactersData
import com.lnight.rickandmorty.domain.model.CharactersListEntity

fun CharactersListResponseDto.toCharactersListEntity(): CharactersListEntity {
    val charactersData = mutableListOf<CharactersData>()
    characters.forEach { result ->
        val status: Boolean? = when (result.status) {
            "Alive" -> true
            "Dead" -> false
            else -> null
        }
        charactersData.add(
            CharactersData(
                id = result.id,
                name = result.name,
                image = result.image,
                gender = result.gender,
                cityName = result.location.name,
                species = result.species,
                status = status,
                locationUrl = result.location.url
            )
        )
    }
    return CharactersListEntity(
        pageInfo = info,
        charactersData = charactersData
    )
}

fun Character.toCharacterData(): CharactersData {

    val status: Boolean? = when (status) {
        "Alive" -> true
        "Dead" -> false
        else -> null
    }

    return CharactersData(
        id = id,
        name = name,
        image = image,
        gender = gender,
        cityName = location.name,
        status = status,
        species = species,
        locationUrl = location.url
    )
}