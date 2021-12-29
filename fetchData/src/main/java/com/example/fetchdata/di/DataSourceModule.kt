package com.example.fetchdata.di

import com.example.datasource.remote.HeroService
import com.example.datasource.remote.HeroServiceImpl
import com.example.entities.remote.RemoteDto
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideRemoteDto(): RemoteDto {
        return RemoteDto()
    }

    @Provides
    @Singleton
    fun provideHttpclient(): HttpClient {
        return HttpClient(Android) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(
                    kotlinx.serialization.json.Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
    }

    @Provides
    @Singleton
    fun provideHeroService(remoteDto: RemoteDto, httpClient: HttpClient): HeroService {
        return HeroServiceImpl(httpClient = httpClient, remoteDto = remoteDto)
    }

}