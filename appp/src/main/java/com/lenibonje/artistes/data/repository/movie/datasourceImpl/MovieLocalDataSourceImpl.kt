package com.lenibonje.artistes.data.repository.movie.datasourceImpl

import com.lenibonje.artistes.data.db.MoviesDao
import com.lenibonje.artistes.data.model.movie.Movie
import com.lenibonje.artistes.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val dao: MoviesDao): MovieLocalDataSource {

    override suspend fun getMoviesFromDb(): List<Movie> = dao.getMovies()

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAllMovies()
        }
    }


}