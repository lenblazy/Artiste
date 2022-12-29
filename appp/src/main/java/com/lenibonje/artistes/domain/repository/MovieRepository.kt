package com.lenibonje.artistes.domain.repository

import com.lenibonje.artistes.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?

}