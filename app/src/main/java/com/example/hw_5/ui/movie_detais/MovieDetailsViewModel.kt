package com.example.hw_5.ui.movie_detais

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw_5.data.model.credits.CreditsResponse
import com.example.hw_5.data.model.movie.MovieResponse
import com.example.hw_5.data.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailsViewModel : ViewModel() {

    private val repository = MoviesRepository()

    private val movie = MutableLiveData<MovieResponse>()
    fun movie() = movie as LiveData<MovieResponse>

    private val actors = MutableLiveData<CreditsResponse>()
    fun actors() = actors as LiveData<CreditsResponse>

    var movieId: Int = 0
        set(value) {
            if (field != value) {
                field = value
                getMovie(movieId)
                getActors(movieId)
            }
        }

    private fun getMovie(movieId: Int){
        repository.getMovieById(movieId).apply {
            movie.postValue(this)
        }
    }

    private fun getActors(movieId: Int){
        repository.getActors(movieId).apply {
            actors.postValue(this)
        }
    }

}