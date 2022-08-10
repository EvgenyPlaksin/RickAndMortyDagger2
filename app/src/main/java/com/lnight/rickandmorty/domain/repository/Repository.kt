package com.lnight.rickandmorty.domain.repository

import com.lnight.rickandmorty.data.remote.dto.Character
import com.lnight.rickandmorty.data.remote.dto.CharactersListResponseDto

interface Repository {

    suspend fun getCharactersList(page: Int): CharactersListResponseDto

    suspend fun getCharacterById(id: Int): Character

}