package com.lenibonje.artistes.presentation.movie

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.lenibonje.artistes.databinding.ActivityMovieBinding
import com.lenibonje.artistes.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding

    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory
    private lateinit var viewModel: MovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as Injector).createMovieSubComponent().inject(this)

        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, movieViewModelFactory)[MovieViewModel::class.java]
        viewModel.getMovies().observe(this) {
            Log.d("MyTag", "imekam")
            it?.let {
                Log.d("MyTag", it.toString())
            }
        }
    }
}