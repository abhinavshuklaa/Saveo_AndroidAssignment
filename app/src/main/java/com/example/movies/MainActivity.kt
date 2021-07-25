package com.example.movies

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.*
import com.example.movies.Model.ResponseModelItem
import kotlinx.android.synthetic.main.activity_main.*
import www.sanju.zoomrecyclerlayout.ZoomRecyclerLayout

class MainActivity : AppCompatActivity(), RecyclerViewItemClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewVertical: RecyclerView
    private lateinit var horizontalViewAdapter: HorizontalViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewVertical = findViewById(R.id.recyclerViewVerticalGrids)
        recyclerView = findViewById(R.id.recyclerViewHorizontal)
        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {

        recyclerViewVertical.apply {
            layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)

            horizontalViewAdapter = HorizontalViewAdapter(this@MainActivity)
//            adapter = horizontalViewAdapter

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

    override fun onItemClicked(position: Int, results: ResponseModelItem) {
        val intent = Intent(this,MovieDetailsActivity::class.java)
        intent.putExtra("movieName",results.name.toString())
        intent.putExtra("premiered",results.premiered.toString())
        intent.putExtra("summary",results.summary.toString())
        val arrayList:ArrayList<String> = ArrayList()
        for( i in results.genres!!.indices){
            arrayList.add(results.genres.get(i))
        }
        intent.putExtra("genre",arrayList)
        intent.putExtra("rating",results.rating.toString())
        intent.putExtra("image",results.image!!.original).toString()
        startActivity(intent)







    }
}