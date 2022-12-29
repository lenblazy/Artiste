package com.lenibonje.artistes.presentation.di.core

import com.lenibonje.artistes.data.repository.artist.datasource.ArtistCacheDataSource
import com.lenibonje.artistes.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.lenibonje.artistes.data.repository.movie.datasource.MovieCacheDataSource
import com.lenibonje.artistes.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.lenibonje.artistes.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.lenibonje.artistes.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }

}