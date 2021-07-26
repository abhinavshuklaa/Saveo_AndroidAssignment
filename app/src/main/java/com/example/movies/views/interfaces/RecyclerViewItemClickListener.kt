package com.example.movies.views.interfaces

import com.example.movies.Model.ResponseModelItem

/**
 * Interface to receive the callbacks on every click of recycler view
 */
interface RecyclerViewItemClickListener {
    fun onItemClicked(
        position: Int,
        results: ResponseModelItem
    )
}