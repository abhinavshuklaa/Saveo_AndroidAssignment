package com.example.movies.views.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.*
import com.example.movies.*
import com.example.movies.Model.ResponseModelItem
import com.example.movies.viewModel.MainActivityViewModel
import com.example.movies.views.adapters.HorizontalViewAdapter
import com.example.movies.views.interfaces.RecyclerViewItemClickListener
import kotlinx.android.synthetic.main.activity_main.*
import www.sanju.zoomrecyclerlayout.ZoomRecyclerLayout

class MainActivity : AppCompatActivity(), RecyclerViewItemClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewVertical: RecyclerView
    private lateinit var horizontalViewAdapter: HorizontalViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setCustomActionBar()
        initialisingRecyclerViews()
        initRecyclerView()
        initViewModel()
    }

    private fun initialisingRecyclerViews() {
        recyclerViewVertical = findViewById(R.id.recyclerViewVerticalGrids)
        recyclerView = findViewById(R.id.recyclerViewHorizontal)
    }

    /**
     * setting the custom action bar as per the design
     */

    private fun setCustomActionBar() {
        getSupportActionBar()?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar()?.setCustomView(R.layout.abs_main_activity)
    }

    /**
     * Setting the recycler view using scope function
     */
    private fun initRecyclerView() {

        recyclerViewVertical.apply {
            layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)

            horizontalViewAdapter = HorizontalViewAdapter(this@MainActivity)

        }

        recyclerView.apply {
            layoutManager =
                ZoomRecyclerLayout(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            val decoration =
                DividerItemDecoration(applicationContext, DividerItemDecoration.HORIZONTAL)
            addItemDecoration(decoration)
            horizontalViewAdapter = HorizontalViewAdapter(this@MainActivity)
            adapter = horizontalViewAdapter

        }
    }

    /**
     * Initialising the ViewModel pattern
     */
    private fun initViewModel() {
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getRecyclerListObserver()?.observe(this, {
            if (it != null) {

                horizontalViewAdapter.submitList(it)
                recyclerViewVertical.adapter = horizontalViewAdapter


            } else {
                Toast.makeText(this, "Failed to fetch Data from the Server", Toast.LENGTH_SHORT)
                    .show()

            }
        })
    }

    /**
     * Overridden method to handle the clicks and transferring data
     */
    override fun onItemClicked(position: Int, results: ResponseModelItem) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra("movieName", results.name.toString())
        intent.putExtra("premiered", results.premiered.toString())
        intent.putExtra("summary", results.summary.toString())
        val arrayList: ArrayList<String> = ArrayList()
        for (i in results.genres!!.indices) {
            arrayList.add(results.genres[i])
        }
        intent.putExtra("genre", arrayList)
        intent.putExtra("rating", results.rating.toString())
        intent.putExtra("duration", results.runtime).toString()
        intent.putExtra("image", results.image!!.original).toString()
        startActivity(intent)


    }
}