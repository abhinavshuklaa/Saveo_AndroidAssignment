package com.example.movies.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.movies.Model.ResponseModelItem
import com.example.movies.views.utils.ResponseModelItemListFactory
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * This class is the link between Model and View OR It Retrieves data from Model and exposes it to the View.
 * This is the model specifically designed for the View.
 */
class MainActivityViewModel : ViewModel() {
    private var responseModelItemList: LiveData<PagedList<ResponseModelItem>>? = null

    init {
        initPaging()
    }

    private fun initPaging() {
        val factory = ResponseModelItemListFactory()
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(10)
            .build()

        val executor: Executor = Executors.newFixedThreadPool(5)
        responseModelItemList = LivePagedListBuilder<Int, ResponseModelItem>(factory, config)
            .setFetchExecutor(executor)
            .build()


    }

    fun getRecyclerListObserver(): LiveData<PagedList<ResponseModelItem>>? {

        return responseModelItemList
    }
}