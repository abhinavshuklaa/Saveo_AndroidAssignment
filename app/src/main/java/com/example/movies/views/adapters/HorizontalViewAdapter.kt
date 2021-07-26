package com.example.movies.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.example.movies.views.utils.DiffUtilCallBack
import com.example.movies.views.viewholders.HorizontalViewViewHolder
import com.example.movies.Model.ResponseModelItem
import com.example.movies.R
import com.example.movies.views.interfaces.RecyclerViewItemClickListener

/**
 * The adapter is the piece that will connect our data to our RecyclerView
 * It determine the ViewHolder which will need to be used to display that data.
 */
class HorizontalViewAdapter(private var listener: RecyclerViewItemClickListener) :
    PagedListAdapter<ResponseModelItem, HorizontalViewViewHolder>(DiffUtilCallBack()) {

    /**
     * This method is called for each ViewHolder to bind it to the adapter.
     * This is where we will pass our data to our ViewHolder.
     */
    override fun onBindViewHolder(holder: HorizontalViewViewHolder, position: Int) {
        holder.setData(getItem(position)!!)
    }

    /**
     * This method is called right when the adapter is created and is used to initialize your ViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_horizontal, parent, false)
        return HorizontalViewViewHolder(inflater, listener)

    }


}