package com.example.hw_5.data.model.credits


import com.google.gson.annotations.SerializedName

data class Person(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?
)