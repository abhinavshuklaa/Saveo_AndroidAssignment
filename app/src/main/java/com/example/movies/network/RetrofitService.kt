package com.example.movies.network

import com.example.movies.Model.ResponseModel
import com.example.movies.Model.ResponseModelItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("shows")
    fun getDataFromAPI(@Query("page") pageNo:Int):Call<List<ResponseModelItem>>

}