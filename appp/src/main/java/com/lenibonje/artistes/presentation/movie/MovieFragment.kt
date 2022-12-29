package com.lenibonje.artistes.presentation.movie

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lenibonje.artistes.R
import com.lenibonje.artistes.databinding.FragmentMovieBinding
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieFragment : Fragment() {

    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory
    private lateinit var viewModel: MovieViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, movieViewModelFactory)[MovieViewModel::class.java]
        viewModel.getMovies().observe(viewLifecycleOwner, Observer {
            it?.let {
                Log.d("MyTag", it.toString())
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}