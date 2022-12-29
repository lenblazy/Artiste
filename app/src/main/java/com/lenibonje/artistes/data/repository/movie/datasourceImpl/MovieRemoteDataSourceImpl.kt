package com.lenibonje.artistes.data.repository.movie.datasourceImpl

import com.lenibonje.artistes.data.api.TMDBService
import com.lenibonje.artistes.data.model.movie.MovieList
import com.lenibonje.artistes.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}