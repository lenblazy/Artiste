package com.lenibonje.artistes.presentation.di.movie

import com.lenibonje.artistes.domain.usecases.GetArtistsUseCase
import com.lenibonje.artistes.domain.usecases.GetMoviesUseCase
import com.lenibonje.artistes.domain.usecases.UpdateArtistsUseCase
import com.lenibonje.artistes.domain.usecases.UpdateMoviesUseCase
import com.lenibonje.artistes.presentation.artist.ArtistViewModelFactory
import com.lenibonje.artistes.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMovieUseCase: GetMoviesUseCase,
        updateMovieUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMovieUseCase, updateMovieUseCase)
    }

}