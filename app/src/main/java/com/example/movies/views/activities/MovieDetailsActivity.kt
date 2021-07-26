package com.example.movies.views.activities

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.movies.R
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
        settingCustomActionBar()
        getDataFromIntent()
        setDataFromIntent()
    }

    /**
     * setting the custom action bar as per the design
     */
    private fun settingCustomActionBar() {
        getSupportActionBar()?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar()?.setCustomView(R.layout.abs_layout);
    }

    /**
     * function for setting the data received via intent
     */
    private fun setDataFromIntent() {
        tvSummary.text = summary
        tvMovieName.text = name
        Glide.with(ivMovieImage).load(imageUrl).centerCrop().into(ivMovieImage)
        tvRatings.text = "⭐⭐⭐${rating}"
        tvPremiereDate.text = "R|${duration}|${premeire}"
        if (list.size == 3) {
            tvGenre.text = list.get(0)
            tvGenre_1.text = list.get(1)
            tvGenre_2.text = list.get(2)
        } else {
            tvGenre.text = "Drame"
            tvGenre_1.text = "Comedy"
            tvGenre_2.text = "Action"
        }

    }

    /**
     * function for receiving the data via intent
     */
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