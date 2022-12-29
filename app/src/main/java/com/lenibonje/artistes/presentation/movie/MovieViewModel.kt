package com.lenibonje.artistes.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.lenibonje.artistes.data.model.movie.Movie
import com.lenibonje.artistes.domain.usecases.GetMoviesUseCase
import com.lenibonje.artistes.domain.usecases.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModel() {

    fun getMovies(): LiveData<List<Movie>?> = liveData {
        val list = getMoviesUseCase.execute()
        emit(list)
    }

    fun updateMovies(): LiveData<List<Movie>?> = liveData {
        val list = updateMoviesUseCase.execute()
        emit(list)
    }

}