package com.example.hw_5.data.api

import com.example.hw_5.BuildConfig
import com.example.hw_5.data.model.credits.CreditsResponse
import com.example.hw_5.data.model.list.MovieListResponse
import com.example.hw_5.data.model.movie.MovieResponse
import com.example.hw_5.utils.API_KEY_KEY
import com.example.hw_5.utils.DEFAULT_SORT_BY_QUERY
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {
    @GET(MOVIE_DETAILS)
    fun getMovieById(
        @Query(MOVIE_ID_QUERY) movieId: Int,
        @Query(API_KEY_KEY) apiKey: String = BuildConfig.API_KEY
    ): MovieResponse

    @GET(MOVIES_LIST)
    fun getMoviesList(
        @Query(SORT_BY_QUERY) sortBy: String = DEFAULT_SORT_BY_QUERY,
        @Query(API_KEY_KEY) apiKey: String = BuildConfig.API_KEY
    ): Call<MovieListResponse>

    @GET(GET_ACTORS)
    fun getActors(
        @Path(MOVIE_ID_PATH) movie_id: Int,
        @Query(API_KEY_KEY) apiKey: String = BuildConfig.API_KEY
    ): CreditsResponse

    private companion object {
        const val MOVIE_DETAILS = "movie"
        const val MOVIES_LIST = "discover/movie"
        const val GET_ACTORS = "/movie/{movie_id}/credits"

        const val MOVIE_ID_QUERY = "movie_id"
        const val SORT_BY_QUERY = "sort_by"
        const val MOVIE_ID_PATH = "movie_id"
    }
}