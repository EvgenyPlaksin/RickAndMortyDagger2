package com.lnight.rickandmorty.data.remote.dto


import com.google.gson.annotations.SerializedName

data class CharactersListResponseDto(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val characters: List<Character>
)
