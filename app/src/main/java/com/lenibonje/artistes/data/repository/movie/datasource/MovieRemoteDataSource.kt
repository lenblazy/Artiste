package com.lenibonje.artistes.data.repository.movie.datasource

import com.lenibonje.artistes.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>

}