package com.example.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.example.movies.Model.ResponseModelItem

class HorizontalViewAdapter (private var listener:RecyclerViewItemClickListener):
    PagedListAdapter<ResponseModelItem, HorizontalViewViewHolder>(DiffUtilCallBack()) {

    override fun onBindViewHolder(holder: HorizontalViewViewHolder, position: Int) {
        holder.setData(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_horizontal, parent, false)
        return HorizontalViewViewHolder(inflater,listener)

    }


}