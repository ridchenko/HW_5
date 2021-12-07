package com.example.hw_5.data.model.credits


import com.google.gson.annotations.SerializedName

data class Media(
    @SerializedName("character")
    val character: String?,
    @SerializedName("episodes")
    val episodes: List<Any>?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("original_name")
    val originalName: String?,
    @SerializedName("seasons")
    val seasons: List<Season>?
)