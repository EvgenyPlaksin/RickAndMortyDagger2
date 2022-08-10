package com.lnight.rickandmorty.di

import android.app.Application
import android.content.Context
import com.lnight.rickandmorty.presentation.MainActivity
import com.lnight.rickandmorty.presentation.list_screen.fragments.CharactersListFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun inject(fragment: CharactersListFragment)
    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application) : Builder

        @BindsInstance
        fun context(context: Context) : Builder

        fun build() : AppComponent
    }
}