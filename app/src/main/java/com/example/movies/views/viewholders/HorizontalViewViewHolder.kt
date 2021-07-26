package com.example.movies.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.Model.ResponseModelItem
import com.example.movies.views.interfaces.RecyclerViewItemClickListener
import kotlinx.android.synthetic.main.item_layout_horizontal.view.*

/**
 * represents each item in our collection and will be used to display it.
 * Let us create our HorizontalViewViewHolder and add a method called setData(SimpleModel model)
 */
class HorizontalViewViewHolder(
    private val view: View,
    private var listener: RecyclerViewItemClickListener
) : RecyclerView.ViewHolder(view) {

    /**
     * function for setting the data for each view
     */
    fun setData(data: ResponseModelItem) {
        view.apply {
            Glide.with(ivAvatar).load(data.image?.medium).centerCrop().into(ivAvatar)
            itemCardHorizontal.setOnClickListener {
                listener.onItemClicked(adapterPosition, data)
            }
        }

    }
}