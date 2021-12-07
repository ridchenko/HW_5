package com.example.hw_5.ui.movies_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.hw_5.databinding.FragmentMoviesListBinding
import com.example.hw_5.ui.base.ViewBindingFragment

class MoviesListFragment : ViewBindingFragment<FragmentMoviesListBinding>() {

    private val viewModel: MovieListViewModel by viewModels()

    private lateinit var rvAdapter: MoviesListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rvAdapter = MoviesListAdapter()
    }


    override fun initUi() {
        initRecycleView()
    }

    private fun initRecycleView() = with(binding.rvMovies){
        adapter = rvAdapter
    }

    override fun initViewModel() = with(viewModel) {
        movieList().observe(viewLifecycleOwner){
            rvAdapter.movies = it
        }
    }

    private fun navigateToDetails(movieId: Int) {
        val action =
            MoviesListFragmentDirections.actionMoviesListFragmentToMovieDetailsFragment(movieId)
        findNavController().navigate(action)
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentMoviesListBinding.inflate(inflater, container, false)

}