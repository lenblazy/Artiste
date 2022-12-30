package com.lenibonje.artistes.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.lenibonje.artistes.data.model.movie.Movie
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoviesDaoTest {

    //to allow executing tasks synchronously
    @get:Rule
    var instanceTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var SUT: MoviesDao
    private lateinit var tmdbDatabase: TMDBDatabase

    @Before
    fun setUp() {
        tmdbDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(), TMDBDatabase::class.java)
            .build()
        SUT = tmdbDatabase.moviesDao()
    }

    @After
    fun tearDown(){
        tmdbDatabase.close()
    }

    @Test
    fun saveMoviesTest() = runBlocking {
        val movies = listOf(
            Movie(1, "OverView1", "posterPath1", "date1", "title1"),
            Movie(2, "OverView2", "posterPath2", "date2", "title2"),
            Movie(3, "OverView3", "posterPath3", "date3", "title3"),
        )

        SUT.saveMovies(movies)

        val allMovies = SUT.getMovies()
        Truth.assertThat(allMovies).isEqualTo(movies)

    }

    @Test
    fun deleteMoviesTest() = runBlocking {
        val movies = listOf<Movie>(
            Movie(1, "OverView1", "posterPath1", "date1", "title1"),
            Movie(2, "OverView2", "posterPath2", "date2", "title2"),
            Movie(3, "OverView3", "posterPath3", "date3", "title3"),
        )

        SUT.saveMovies(movies)

        SUT.deleteAllMovies()

        val moviesResult = SUT.getMovies()
        Truth.assertThat(moviesResult).isEmpty()
    }

}