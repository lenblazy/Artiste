package com.lenibonje.artistes.presentation.di

import com.lenibonje.artistes.presentation.di.artist.ArtistSubComponent
import com.lenibonje.artistes.presentation.di.movie.MovieSubComponent
import com.lenibonje.artistes.presentation.di.tv.TvSubComponent


interface Injector {

    fun createMovieSubComponent(): MovieSubComponent

    fun createTvSubComponent(): TvSubComponent

    fun createArtistSubComponent(): ArtistSubComponent

}