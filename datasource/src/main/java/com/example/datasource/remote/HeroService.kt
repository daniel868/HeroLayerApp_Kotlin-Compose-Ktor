package com.example.datasource.remote

import com.example.entities.hero.Hero

interface HeroService {
    suspend fun getHeroes(): List<Hero>
}