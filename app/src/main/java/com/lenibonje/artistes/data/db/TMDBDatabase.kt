package com.lenibonje.artistes.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lenibonje.artistes.data.model.artist.Artist
import com.lenibonje.artistes.data.model.movie.Movie
import com.lenibonje.artistes.data.model.tvshow.TVShow

@Database(
    entities = [Movie::class, Artist::class, TVShow::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase: RoomDatabase() {

    abstract fun moviesDao(): MoviesDao

    abstract fun artistsDao(): ArtistsDao

    abstract fun tvShowsDao(): TvShowsDao

}