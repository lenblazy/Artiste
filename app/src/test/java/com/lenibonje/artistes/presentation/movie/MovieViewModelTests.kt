package com.lenibonje.artistes.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.lenibonje.artistes.data.model.movie.Movie
import com.lenibonje.artistes.data.repository.movie.FakeMovieRepository
import com.lenibonje.artistes.domain.usecases.GetMoviesUseCase
import com.lenibonje.artistes.domain.usecases.UpdateMoviesUseCase
import com.lenibonje.artistes.getOrAwaitValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieViewModelTests {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var SUT: MovieViewModel

    @Before
    fun setUp() {
        val fakeMovieRepository = FakeMovieRepository()
        val getMoviesUseCase = GetMoviesUseCase(fakeMovieRepository)
        val updateMoviesUseCase = UpdateMoviesUseCase(fakeMovieRepository)
        SUT = MovieViewModel(getMoviesUseCase, updateMoviesUseCase)
    }

    @Test
    fun getMovies_returnCurrentList() {
        val movies = mutableListOf<Movie>()
        movies.addAll(
            listOf(
                Movie(1, "OverView1", "posterPath1", "date1", "title1"),
                Movie(2, "OverView2", "posterPath2", "date2", "title2"),
            )
        )

        val currentList = SUT.getMovies().getOrAwaitValue()
        assertThat(currentList).isEqualTo(movies)

    }

    @Test
    fun updateMovies_returnCurrentList() {
        val movies = mutableListOf<Movie>()
        movies.addAll(
            listOf(
                Movie(3, "OverView3", "posterPath3", "date3", "title3"),
                Movie(4, "OverView4", "posterPath4", "date4", "title4"),
            )
        )

        val updatedList = SUT.updateMovies().getOrAwaitValue()
        assertThat(updatedList).isEqualTo(movies)

    }
}