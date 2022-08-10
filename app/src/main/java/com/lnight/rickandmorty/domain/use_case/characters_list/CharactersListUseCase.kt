package com.lnight.rickandmorty.domain.use_case.characters_list


import com.lnight.rickandmorty.common.Resource
import com.lnight.rickandmorty.domain.model.CharactersListEntity
import com.lnight.rickandmorty.domain.model.mappers.toCharactersListEntity
import com.lnight.rickandmorty.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CharactersListUseCase @Inject constructor(
    private val apiRepository: Repository
) {

     operator fun invoke(page: Int): Flow<Resource<CharactersListEntity>> = flow {
        try {
            emit(Resource.Loading<CharactersListEntity>())
            val data = apiRepository.getCharactersList(page)
            emit(Resource.Success<CharactersListEntity>(data.toCharactersListEntity()))
        } catch (e: HttpException) {
            emit(
                Resource.Error<CharactersListEntity>(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<CharactersListEntity>("Couldn't reach server, check your internet connection"))
        }
    }

}