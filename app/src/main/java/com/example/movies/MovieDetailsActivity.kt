package com.example.movies

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var name: String
    private lateinit var imageUrl: String

    private lateinit var duration: String
    private lateinit var premeire: String
    private lateinit var summary: String
    private lateinit var rating: String
    private var list: ArrayList<String> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        getSupportActionBar()?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar()?.setCustomView(R.layout.abs_layout);
        getDataFromIntent()
        setDataFromIntent()
    }

    private fun setDataFromIntent() {
        tvSummary.text = summary
        tvMovieName.text = name
        Glide.with(ivMovieImage).load(imageUrl).centerCrop().into(ivMovieImage)
        tvRatings.text = "⭐⭐⭐${rating}"
        tvPremiereDate.text = "R|${duration}|${premeire}"
        if (list.size != 0) {
            tvGenre.text = list.get(0)
            tvGenre_1.visibility = View.INVISIBLE
            tvGenre_2.visibility = View.INVISIBLE

        } else if (list.size == 2)
            tvGenre_1.text = list.get(1)
        else if (list.size == 3) tvGenre_2.text = list.get(2)
        else {
            tvGenre.text = "No Data"
        }

    }

    private fun getDataFromIntent() {
        name = intent.getStringExtra("movieName").toString()
        premeire = intent.getStringExtra("premiered").toString()
        summary = intent.getStringExtra("summary").toString()
        rating = intent.getStringExtra("rating").toString()
        duration = intent.getStringExtra("duration").toString()
        imageUrl = intent.getStringExtra("image").toString()
        list = intent.getStringArrayListExtra("genre")!!
    }
}