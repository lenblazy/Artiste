package com.lenibonje.artistes.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.lenibonje.artistes.data.db.ArtistsDao
import com.lenibonje.artistes.data.db.MoviesDao
import com.lenibonje.artistes.data.db.TMDBDatabase
import com.lenibonje.artistes.data.db.TvShowsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {

    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context): TMDBDatabase{
        return Room.databaseBuilder(context.applicationContext, TMDBDatabase::class.java, "tmdb_client")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MoviesDao{
        return tmdbDatabase.moviesDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistsDao {
        return tmdbDatabase.artistsDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TvShowsDao {
        return tmdbDatabase.tvShowsDao()
    }

}