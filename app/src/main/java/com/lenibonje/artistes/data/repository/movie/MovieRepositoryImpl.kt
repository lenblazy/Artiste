package com.lenibonje.artistes.data.repository.movie

import android.util.Log
import com.lenibonje.artistes.data.model.movie.Movie
import com.lenibonje.artistes.data.repository.movie.datasource.MovieCacheDataSource
import com.lenibonje.artistes.data.repository.movie.datasource.MovieLocalDataSource
import com.lenibonje.artistes.data.repository.movie.datasource.MovieRemoteDataSource
import com.lenibonje.artistes.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieCacheDataSource: MovieCacheDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieRemoteDataSource: MovieRemoteDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie> = getMoviesFromCache()
    override suspend fun updateMovies(): List<Movie> {
        val newListOfMovies = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    private suspend fun getMoviesFromApi(): List<Movie>{
        lateinit var moviesList: List<Movie>

        Log.d("MyTag", "get movies from api")
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null){
                moviesList = body.movies
            }

        }catch (e: Exception){
            Log.e("MyTag", e.message.toString())
        }

        return moviesList
    }

    private suspend fun getMoviesFromDb(): List<Movie>{
        lateinit var moviesList: List<Movie>

        try {
            Log.d("MyTag", "getmoviesfromdb")
            moviesList = movieLocalDataSource.getMoviesFromDb()

        }catch (e: Exception){
            Log.d("MyTag", e.message.toString())
        }

        if (moviesList.isNotEmpty()){
            return moviesList
        }else{
            moviesList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDB(moviesList)
        }

        return moviesList
    }

    private suspend fun getMoviesFromCache(): List<Movie>{
        lateinit var moviesList: List<Movie>
        Log.d("MyTag", "getmovies from cache")
        try {
            moviesList = movieCacheDataSource.getMoviesFromCache()
        }catch (e: Exception){
            Log.d("MyTag", e.message.toString())
        }

        if (moviesList.isNotEmpty()){
            return moviesList
        }else{
            moviesList = getMoviesFromDb()
            movieCacheDataSource.saveMoviesToCache(moviesList)
        }

        return moviesList
    }

}