package com.example.movies.Model


import com.google.gson.annotations.SerializedName

data class Self(
    @SerializedName("href")
    val href: String?
)