package com.lenibonje.artistes.presentation.movie

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.lenibonje.artistes.R
import com.lenibonje.artistes.databinding.ActivityMovieBinding
import com.lenibonje.artistes.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding

    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory
    private lateinit var viewModel: MovieViewModel

    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as Injector).createMovieSubComponent().inject(this)

        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        viewModel = ViewModelProvider(this, movieViewModelFactory)[MovieViewModel::class.java]
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        binding.movieProgressBar.visibility = VISIBLE
        viewModel.getMovies().observe(this) {
            it?.let {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = GONE
                return@observe
            }
            Toast.makeText(applicationContext, "No data available", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initRecyclerView() {
        adapter = MovieAdapter()
        binding.movieRecyclerView.adapter = adapter
    }

    private fun updateMovies() {
        binding.movieProgressBar.visibility = VISIBLE
        viewModel.updateMovies().observe(this) {
            it?.let {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = GONE
                return@observe
            }
            Toast.makeText(applicationContext, "No data available", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.ic_update, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}