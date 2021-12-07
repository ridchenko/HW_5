package com.example.hw_5.data.model.credits


import com.google.gson.annotations.SerializedName

data class Season(
    @SerializedName("air_date")
    val airDate: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("season_number")
    val seasonNumber: Int?
)