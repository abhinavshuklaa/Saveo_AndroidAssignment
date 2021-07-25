package com.example.movies

import androidx.recyclerview.widget.DiffUtil
import com.example.movies.Model.ResponseModelItem

class DiffUtilCallBack : DiffUtil.ItemCallback<ResponseModelItem>() {
    override fun areItemsTheSame(oldItem: ResponseModelItem, newItem: ResponseModelItem): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(
        oldItem: ResponseModelItem,
        newItem: ResponseModelItem
    ): Boolean {
        return oldItem.name == newItem.name

    }
}