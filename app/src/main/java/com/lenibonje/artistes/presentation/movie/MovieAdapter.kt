package com.lenibonje.artistes.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lenibonje.artistes.data.model.movie.Movie
import com.lenibonje.artistes.databinding.ListItemBinding

class MovieAdapter(): RecyclerView.Adapter<MovieViewHolder>() {

    private val movieList = ArrayList<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater)
        return MovieViewHolder(binding)
    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    fun setList(list: List<Movie>) {
        movieList.clear()
        movieList.addAll(list)
    }

}

class MovieViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        binding.apply {
            titleTextView.text = movie.title
            descriptionTextView.text = movie.overview
            val posterURL = "https://image.tmdb.org/t/p/w500" + movie.posterPath
            Glide.with(imageView.context)
                .load(posterURL)
                .into(imageView)
        }
    }
}