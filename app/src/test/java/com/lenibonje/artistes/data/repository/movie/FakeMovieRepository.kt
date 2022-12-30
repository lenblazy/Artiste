package com.lenibonje.artistes.data.repository.movie

import com.lenibonje.artistes.data.model.movie.Movie
import com.lenibonje.artistes.domain.repository.MovieRepository

class FakeMovieRepository : MovieRepository {

    private val movies = mutableListOf<Movie>()

    init {
        movies.addAll(
            listOf(
                Movie(1, "OverView1", "posterPath1", "date1", "title1"),
                Movie(2, "OverView2", "posterPath2", "date2", "title2"),
            )
        )
    }

    override suspend fun getMovies(): List<Movie> {
        return movies
    }

    override suspend fun updateMovies(): List<Movie> {
        movies.clear()
        movies.addAll(
            listOf(
                Movie(3, "OverView3", "posterPath3", "date3", "title3"),
                Movie(4, "OverView4", "posterPath4", "date4", "title4"),
            )
        )
        return movies
    }

}