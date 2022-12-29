package com.lenibonje.artistes.presentation.di

import android.app.Application
import com.lenibonje.artistes.presentation.di.artist.ArtistSubComponent
import com.lenibonje.artistes.presentation.di.core.*
import com.lenibonje.artistes.presentation.di.movie.MovieSubComponent
import com.lenibonje.artistes.presentation.di.tv.TvSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule("https://api.themoviedb.org/3/"))
            .remoteDataModule(RemoteDataModule("70808bd4ac463ba4394ee1a35cd6fa2e"))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvSubComponent(): TvSubComponent {
        return appComponent.tvSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}