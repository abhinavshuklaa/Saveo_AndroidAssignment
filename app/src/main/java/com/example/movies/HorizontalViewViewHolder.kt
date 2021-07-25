package com.example.movies

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.Model.ResponseModelItem
import kotlinx.android.synthetic.main.item_layout_horizontal.view.*

class HorizontalViewViewHolder(private val view:View) : RecyclerView.ViewHolder(view) {

    fun setData(data: ResponseModelItem){
        view.apply {
            Glide.with(ivAvatar).load(data.image?.original).into(ivAvatar)
//            tvEmail.text=data.name
        }

    }
}