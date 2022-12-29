package com.lenibonje.artistes.presentation.di.core

import com.lenibonje.artistes.presentation.di.artist.ArtistSubComponent
import com.lenibonje.artistes.presentation.di.movie.MovieSubComponent
import com.lenibonje.artistes.presentation.di.tv.TvSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CacheDataModule::class,
        DbModule::class,
        LocalDataModule::class,
        NetModule::class,
        RemoteDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
    ]
)
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory

    fun tvSubComponent(): TvSubComponent.Factory

    fun artistSubComponent(): ArtistSubComponent.Factory

}