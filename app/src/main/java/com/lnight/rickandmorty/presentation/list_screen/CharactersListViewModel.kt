package com.lnight.rickandmorty.presentation.list_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.lnight.rickandmorty.common.Resource
import com.lnight.rickandmorty.domain.model.CharactersListEntity
import com.lnight.rickandmorty.domain.use_case.characters_list.CharactersListUseCase
import dagger.MapKey
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.reflect.KClass

class CharactersListViewModel(
    private val charactersListUseCase: CharactersListUseCase
) : ViewModel() {

    private val _charactersList = MutableSharedFlow<Resource<CharactersListEntity>>()
    val charactersList = _charactersList.asSharedFlow()

    init {
        getCharacters()
    }

    fun getCharacters(page: Int = 1) {
        viewModelScope.launch {
            charactersListUseCase(page).collect {
                _charactersList.emit(it)
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    class Factory @Inject constructor(
        private val charactersListUseCase: CharactersListUseCase
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == CharactersListViewModel::class)
            return CharactersListViewModel(charactersListUseCase) as T
        }
    }

}