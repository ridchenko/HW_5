package com.example.hw_5.ui.movies_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw_5.data.model.list.Result
import com.example.hw_5.data.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieListViewModel : ViewModel() {

    private val movieList = MutableLiveData<List<Result>>()
    fun movieList() = movieList as LiveData<List<Result>>

    private val repository = MoviesRepository()

    init {
        getMoviesList()
    }

    fun getMoviesList() = viewModelScope.launch(Dispatchers.IO){
        repository.getMoviesList().run {
            this.execute().body()?.results?.let {
                movieList.postValue(it)
                Log.e("MovieListViewModel", "getMoviesList: $it", )
            }
        }
    }
}