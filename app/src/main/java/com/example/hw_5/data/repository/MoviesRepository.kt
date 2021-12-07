package com.example.hw_5.data.repository

import com.example.hw_5.data.api.RetrofitBuilder

class MoviesRepository {
    private val service = RetrofitBuilder.apiService

    fun getMovieById(movieId: Int) = service.getMovieById(movieId)
    fun getMoviesList() = service.getMoviesList()
    fun getActors(movieId: Int) = service.getActors(movieId)

}