package com.example.movies.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroFitInstance {
    companion object {

        private val httpLoggingInterceptor =
            run {
                val httpLoggingInterceptor1 = HttpLoggingInterceptor()
                httpLoggingInterceptor1.apply {
                    httpLoggingInterceptor1.level = HttpLoggingInterceptor.Level.BODY
                }
            }

        fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(" https://api.tvmaze.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build())
                .build()
        }
    }
}