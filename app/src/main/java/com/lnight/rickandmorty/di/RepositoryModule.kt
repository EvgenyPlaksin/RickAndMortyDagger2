package com.lnight.rickandmorty.di

import com.lnight.rickandmorty.data.repository.RepositoryImpl
import com.lnight.rickandmorty.domain.repository.Repository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindRepository(
        repositoryImpl: RepositoryImpl
    ) : Repository

}