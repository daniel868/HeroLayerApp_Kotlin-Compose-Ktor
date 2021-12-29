package com.example.datasource.remote

import com.example.entities.hero.Hero
import com.example.entities.remote.EndPoint
import com.example.entities.remote.HeroRemoteDto
import com.example.entities.remote.RemoteDto
import io.ktor.client.*
import io.ktor.client.request.*

class HeroServiceImpl(
    private val httpClient: HttpClient,
    private val remoteDto: RemoteDto
) : HeroService {
    override suspend fun getHeroes(): List<Hero> {
        return httpClient.get<List<HeroRemoteDto>> {
            url(EndPoint.HERO_STATS)
        }.map {
            remoteDto.mapTo(it)
        }
    }
}