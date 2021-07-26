package com.example.movies.views.utils

import androidx.paging.PageKeyedDataSource
import com.example.movies.Model.ResponseModelItem
import com.example.movies.network.RetroFitInstance
import com.example.movies.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResponseModelItemSource() : PageKeyedDataSource<Int, ResponseModelItem>() {


    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, ResponseModelItem>
    ) {

        val retroFitInstance = RetroFitInstance.getInstance().create(RetrofitService::class.java)
        val call = retroFitInstance.getDataFromAPI(params.key)
        call.enqueue(object : Callback<List<ResponseModelItem>> {


            override fun onResponse(
                call: Call<List<ResponseModelItem>>,
                response: Response<List<ResponseModelItem>>
            ) {
                if (response.isSuccessful) {
                    callback.onResult(response?.body()!!, params.key + 1)


                }
            }

            override fun onFailure(call: Call<List<ResponseModelItem>>, t: Throwable) {

            }

        })

    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, ResponseModelItem>
    ) {

    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, ResponseModelItem>
    ) {

        val retroFitInstance = RetroFitInstance.getInstance().create(RetrofitService::class.java)
        val call = retroFitInstance.getDataFromAPI(1)
        call.enqueue(object : Callback<List<ResponseModelItem>> {


            override fun onResponse(
                call: Call<List<ResponseModelItem>>,
                response: Response<List<ResponseModelItem>>
            ) {
                if (response.isSuccessful) {
                    callback.onResult(response.body()!!, null, 2)

                }
            }

            override fun onFailure(call: Call<List<ResponseModelItem>>, t: Throwable) {
            }

        })

    }
}