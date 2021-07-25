package com.example.movies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var name: String
    private lateinit var imageUrl: String
    private lateinit var premeire: String
    private lateinit var summary: String
    private lateinit var rating: String
    private var list: ArrayList<String> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        getDataFromIntent()
        setDataFromIntent()
    }

    private fun setDataFromIntent() {
        tvSummary.text = summary
        tvMovieName.text = name
        Glide.with(ivMovieImage).load(imageUrl).centerCrop().into(ivMovieImage)
        tvRatings.text = rating
        tvPremiereDate.text = premeire
        tvGenre.text = list.get(0)

    }

    private fun getDataFromIntent() {
        name = intent.getStringExtra("movieName").toString()
        premeire = intent.getStringExtra("premiered").toString()
        summary = intent.getStringExtra("summary").toString()
        rating = intent.getStringExtra("rating").toString()
        imageUrl = intent.getStringExtra("image").toString()
        list = intent.getStringArrayListExtra("genre")!!
    }
}