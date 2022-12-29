package com.lenibonje.artistes.presentation.di.core

import com.lenibonje.artistes.data.api.TMDBService
import com.lenibonje.artistes.data.repository.artist.datasource.ArtistRemoteDataSource
import com.lenibonje.artistes.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.lenibonje.artistes.data.repository.movie.datasource.MovieRemoteDataSource
import com.lenibonje.artistes.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.lenibonje.artistes.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.lenibonje.artistes.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }
}