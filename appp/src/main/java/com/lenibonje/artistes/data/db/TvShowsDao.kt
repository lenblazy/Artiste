package com.lenibonje.artistes.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lenibonje.artistes.data.model.movie.Movie
import com.lenibonje.artistes.data.model.movie.MovieList
import com.lenibonje.artistes.data.model.tvshow.TVShow
import com.lenibonje.artistes.data.model.tvshow.TVShowList

@Dao
interface TvShowsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(list: List<TVShow>)

    @Query("DELETE FROM tbl_popular_tv_shows")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM tbl_popular_tv_shows")
    suspend fun getTvShows(): List<TVShow>

}