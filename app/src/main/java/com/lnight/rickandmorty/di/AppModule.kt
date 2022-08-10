package com.lnight.rickandmorty.di

import dagger.Module

@Module(includes = [NetworkModule::class, RepositoryModule::class])
object AppModule
