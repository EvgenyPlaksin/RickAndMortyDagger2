package com.lnight.rickandmorty.presentation.list_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lnight.rickandmorty.domain.use_case.characters_list.CharactersListUseCase
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class CharactersListViewModelProvider @Inject constructor(
    private val charactersListUseCase: CharactersListUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CharactersListViewModel(charactersListUseCase) as T
    }
}