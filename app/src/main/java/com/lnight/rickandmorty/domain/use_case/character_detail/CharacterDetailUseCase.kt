package com.lnight.rickandmorty.domain.use_case.character_detail

import com.lnight.rickandmorty.common.Resource
import com.lnight.rickandmorty.domain.model.CharactersData
import com.lnight.rickandmorty.domain.model.mappers.toCharacterData
import com.lnight.rickandmorty.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CharacterDetailUseCase @Inject constructor(
    private val apiRepository: Repository
) {

     operator fun invoke(id: Int): Flow<Resource<CharactersData>> = flow {
        try {
            emit(Resource.Loading<CharactersData>())
            val data = apiRepository.getCharacterById(id)
            emit(Resource.Success<CharactersData>(data.toCharacterData()))
        } catch (e: HttpException) {
            emit(
                Resource.Error<CharactersData>(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<CharactersData>("Couldn't reach server, check your internet connection"))
        }
    }
}