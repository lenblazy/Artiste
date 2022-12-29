package com.lenibonje.artistes.domain.usecases

import com.lenibonje.artistes.data.model.movie.Movie
import com.lenibonje.artistes.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()

}