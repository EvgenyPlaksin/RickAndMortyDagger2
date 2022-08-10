package com.lnight.rickandmorty.common

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.lnight.rickandmorty.RickAndMortyApp
import com.lnight.rickandmorty.di.AppComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

val Context.appComponent: AppComponent
get() = when(this) {
    is RickAndMortyApp -> appComponent
    else -> this.applicationContext.appComponent
}

fun <T> Fragment.collectLifecycleFlow(flow: Flow<T>, collect: suspend (T) -> Unit) {
    viewLifecycleOwner.lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.collect(collect)
        }
    }
}

//inline fun <reified T : ViewModel> Fragment.injectViewModel(factory: ViewModelProvider.Factory): T {
//    return ViewModelProvider(this, factory)[T::class.java]
//}