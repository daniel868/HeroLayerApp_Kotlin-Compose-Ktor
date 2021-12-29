package com.example.layerstructureheroapp.di

import com.example.datasource.remote.HeroService
import com.example.fetchdata.filter.FilterHeroes
import com.example.fetchdata.remote.GetHeroes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FetchDataModule {
    @Provides
    @Singleton
    fun provideGetHeroes(
        heroService: HeroService
    ): GetHeroes {
        return GetHeroes(heroService)
    }

    @Provides
    @Singleton
    fun provideFilterHeroes(): FilterHeroes {
        return FilterHeroes()
    }
}