package com.example.movies.views.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.movies.Model.ResponseModelItem

/**
 * Class helpful in checking the contents of each page(pagination)
 */
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