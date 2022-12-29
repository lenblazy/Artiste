package com.lenibonje.artistes.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lenibonje.artistes.data.model.artist.Artist
import com.lenibonje.artistes.data.model.artist.ArtistList
import com.lenibonje.artistes.data.model.movie.Movie
import com.lenibonje.artistes.data.model.movie.MovieList

@Dao
interface ArtistsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(list: List<Artist>)

    @Query("DELETE FROM tbl_popular_artists")
    suspend fun deleteAllArtists()

    @Query("SELECT * FROM tbl_popular_artists")
    suspend fun getArtists(): List<Artist>

}