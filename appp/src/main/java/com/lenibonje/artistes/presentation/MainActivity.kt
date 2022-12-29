package com.lenibonje.artistes.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lenibonje.artistes.databinding.ActivityMainBinding
import com.lenibonje.artistes.presentation.artist.ArtistActivity
import com.lenibonje.artistes.presentation.movie.MovieActivity
import com.lenibonje.artistes.presentation.tv.TvActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnMovies.setOnClickListener {
            startActivity(Intent(this, MovieActivity::class.java))
        }

        binding.btnArtists.setOnClickListener {
            startActivity(Intent(this, ArtistActivity::class.java))
        }

        binding.btnShow.setOnClickListener {
            startActivity(Intent(this, TvActivity::class.java))
        }

    }
}