package com.lnight.rickandmorty.data.repository

import com.lnight.rickandmorty.data.remote.RickAndMortyApi
import com.lnight.rickandmorty.data.remote.dto.Character
import com.lnight.rickandmorty.data.remote.dto.CharactersListResponseDto
import com.lnight.rickandmorty.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi
) : Repository {

    override suspend fun getCharactersList(page: Int): CharactersListResponseDto {
        return api.getCharactersList(page)
    }

    override suspend fun getCharacterById(id: Int): Character {
        return api.getCharacterById(id)
    }

}