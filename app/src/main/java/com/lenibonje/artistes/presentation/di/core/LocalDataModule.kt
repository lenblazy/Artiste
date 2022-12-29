package com.lenibonje.artistes.presentation.di.core

import com.lenibonje.artistes.data.db.ArtistsDao
import com.lenibonje.artistes.data.db.MoviesDao
import com.lenibonje.artistes.data.db.TvShowsDao
import com.lenibonje.artistes.data.repository.artist.datasource.ArtistLocalDataSource
import com.lenibonje.artistes.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.lenibonje.artistes.data.repository.movie.datasource.MovieLocalDataSource
import com.lenibonje.artistes.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.lenibonje.artistes.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.lenibonje.artistes.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(moviesDao: MoviesDao): MovieLocalDataSource{
        return MovieLocalDataSourceImpl(moviesDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(dao: ArtistsDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(dao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(dao: TvShowsDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(dao)
    }

}