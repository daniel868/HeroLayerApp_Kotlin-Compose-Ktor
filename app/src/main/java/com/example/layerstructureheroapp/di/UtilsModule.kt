package com.example.layerstructureheroapp.di

import android.app.Application
import coil.ImageLoader
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UtilsModule {

    @Singleton
    @Provides
    fun provideImageLoader(app: Application): ImageLoader {
        return ImageLoader.Builder(app)
            .availableMemoryPercentage(.25)
            .crossfade(true)
            .build()
    }
}