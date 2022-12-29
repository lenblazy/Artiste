package com.lenibonje.artistes.data.repository.movie.datasource

import com.lenibonje.artistes.data.model.movie.Movie
import com.lenibonje.artistes.data.model.movie.MovieList
import retrofit2.Response

interface MovieCacheDataSource {

    suspend fun getMoviesFromCache(): List<Movie>

    suspend fun saveMoviesToCache(movies: List<Movie>)

}