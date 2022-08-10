package com.lnight.rickandmorty

import android.app.Application
import com.lnight.rickandmorty.di.AppComponent
import com.lnight.rickandmorty.di.DaggerAppComponent

class RickAndMortyApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .context(this)
            .build()
    }

}