package com.lenibonje.artistes.data.repository.movie.datasource

import com.lenibonje.artistes.data.model.movie.Movie
import com.lenibonje.artistes.data.model.movie.MovieList
import retrofit2.Response

interface MovieLocalDataSource {

    suspend fun getMoviesFromDb(): List<Movie>

    suspend fun saveMoviesToDB(movies:List<Movie>)

    suspend fun clearAll()

}