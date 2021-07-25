package com.example.movies

import com.example.movies.Model.ResponseModelItem

interface RecyclerViewItemClickListener {
    fun onItemClicked(
        position: Int,
        results: ResponseModelItem
    )
}