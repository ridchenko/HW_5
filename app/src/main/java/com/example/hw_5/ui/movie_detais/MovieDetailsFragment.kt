package com.example.hw_5.ui.movie_detais

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.hw_5.databinding.FragmentMovieDetailsBinding
import com.example.hw_5.ui.base.ViewBindingFragment

class MovieDetailsFragment : ViewBindingFragment<FragmentMovieDetailsBinding>() {

    private val viewModel: MovieDetailsViewModel by viewModels()
    private val args: MovieDetailsFragmentArgs by navArgs()

    override fun initViewModel() = with(viewModel) {
        movieId = args.movieId

        movie().observe(viewLifecycleOwner) {
            // TODO: work with data
        }

        actors().observe(viewLifecycleOwner){

        }
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentMovieDetailsBinding.inflate(inflater, container, false)
}