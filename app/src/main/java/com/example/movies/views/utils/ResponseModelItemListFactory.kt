package com.example.movies.views.utils

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.movies.Model.ResponseModelItem


class ResponseModelItemListFactory :
    DataSource.Factory<Int, ResponseModelItem>() {
    private var mutableLiveData: MutableLiveData<ResponseModelItemSource>? = null

    init {

        mutableLiveData = MutableLiveData()

    }

    override fun create(): DataSource<Int, ResponseModelItem> {

        val listDataSource = ResponseModelItemSource()
        mutableLiveData?.postValue(listDataSource)
        return listDataSource

    }
}