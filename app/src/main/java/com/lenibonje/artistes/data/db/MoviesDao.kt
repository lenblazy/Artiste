package com.lenibonje.artistes.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lenibonje.artistes.data.model.movie.Movie

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(list: List<Movie>)

    @Query("DELETE FROM tbl_popular_movies")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM tbl_popular_movies")
    suspend fun getMovies(): List<Movie>

}