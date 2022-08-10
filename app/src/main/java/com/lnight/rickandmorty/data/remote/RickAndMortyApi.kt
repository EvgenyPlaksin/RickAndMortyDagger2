package com.lnight.rickandmorty.data.remote

import com.lnight.rickandmorty.data.remote.dto.CharactersListResponseDto
import com.lnight.rickandmorty.data.remote.dto.Character
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {

    @GET("character")
    suspend fun getCharactersList(
        @Query("page") page: Int
    ): CharactersListResponseDto

    @GET("character/{id}")
    suspend fun getCharacterById(
        @Path("id") id: Int
    ): Character

}