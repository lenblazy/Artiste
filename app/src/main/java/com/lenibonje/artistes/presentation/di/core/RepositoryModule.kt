package com.lenibonje.artistes.presentation.di.core

import com.lenibonje.artistes.data.repository.artist.ArtistsRepositoryImpl
import com.lenibonje.artistes.data.repository.artist.datasource.ArtistCacheDataSource
import com.lenibonje.artistes.data.repository.artist.datasource.ArtistLocalDataSource
import com.lenibonje.artistes.data.repository.artist.datasource.ArtistRemoteDataSource
import com.lenibonje.artistes.data.repository.movie.MovieRepositoryImpl
import com.lenibonje.artistes.data.repository.movie.datasource.MovieCacheDataSource
import com.lenibonje.artistes.data.repository.movie.datasource.MovieLocalDataSource
import com.lenibonje.artistes.data.repository.movie.datasource.MovieRemoteDataSource
import com.lenibonje.artistes.data.repository.tvshow.TvShowRepositoryImpl
import com.lenibonje.artistes.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.lenibonje.artistes.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.lenibonje.artistes.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.lenibonje.artistes.domain.repository.ArtistsRepository
import com.lenibonje.artistes.domain.repository.MovieRepository
import com.lenibonje.artistes.domain.repository.TvShowsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieCacheDataSource: MovieCacheDataSource,
        movieLocalDataSource: MovieLocalDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieCacheDataSource,
            movieLocalDataSource,
            movieRemoteDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource
    ): TvShowsRepository {
        return TvShowRepositoryImpl(
           tvShowCacheDataSource,tvShowLocalDataSource,tvShowRemoteDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistCacheDataSource: ArtistCacheDataSource,
        artistLocalDataSource: ArtistLocalDataSource
    ): ArtistsRepository {
        return ArtistsRepositoryImpl(
            artistCacheDataSource,
            artistLocalDataSource,
            artistRemoteDataSource
        )
    }
}