package com.lenibonje.artistes.presentation.di.core

import android.content.Context
import com.lenibonje.artistes.presentation.di.artist.ArtistSubComponent
import com.lenibonje.artistes.presentation.di.movie.MovieSubComponent
import com.lenibonje.artistes.presentation.di.tv.TvSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    subcomponents = [
        MovieSubComponent::class,
        ArtistSubComponent::class,
        TvSubComponent::class,
    ]
)
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }


}