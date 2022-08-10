package com.lnight.rickandmorty.domain.model

import com.lnight.rickandmorty.data.remote.dto.Info

data class CharactersListEntity(
    val pageInfo: Info,
    val charactersData: List<CharactersData>
)