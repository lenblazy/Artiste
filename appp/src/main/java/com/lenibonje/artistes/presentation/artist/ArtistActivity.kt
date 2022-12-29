package com.lenibonje.artistes.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lenibonje.artistes.R
import com.lenibonje.artistes.databinding.ActivityArtistBinding
import com.lenibonje.artistes.presentation.di.Injector
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArtistBinding

    @Inject
    lateinit var artistViewModelFactory: ArtistViewModelFactory

    private lateinit var viewModel: ArtistViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as Injector).createArtistSubComponent().inject(this)

        viewModel = ViewModelProvider(this, artistViewModelFactory)[ArtistViewModel::class.java]

        viewModel.getArtist().observe(this, Observer {
            it?.let {
                Log.d("MyTag", it.toString())
            }
        })

    }
}