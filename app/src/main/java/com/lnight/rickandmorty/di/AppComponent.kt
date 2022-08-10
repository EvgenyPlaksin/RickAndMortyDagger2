package com.lnight.rickandmorty.di

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(fragment: Fragment)
    fun inject(activity: AppCompatActivity)
}