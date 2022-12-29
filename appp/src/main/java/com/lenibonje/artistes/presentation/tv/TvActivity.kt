package com.lenibonje.artistes.presentation.tv

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lenibonje.artistes.databinding.ActivityTvBinding
import com.lenibonje.artistes.presentation.di.Injector
import javax.inject.Inject

class TvActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTvBinding

    @Inject
    lateinit var tvShowViewModelFactory: TvShowViewModelFactory

    private lateinit var viewModel: TvShowViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTvBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as Injector).createTvSubComponent().inject(this)

        viewModel = ViewModelProvider(this, tvShowViewModelFactory)[TvShowViewModel::class.java]

        viewModel.getTvShows().observe(this) {
            it?.let {
                Log.d("MyTag", it.toString())
            }
        }

    }
}