package com.example.movies

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.Model.ResponseModelItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var horizontalViewAdapter: HorizontalViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recyclerViewHorizontal)
        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
            val decoration =
                DividerItemDecoration(applicationContext, DividerItemDecoration.HORIZONTAL)
            addItemDecoration(decoration)
            horizontalViewAdapter = HorizontalViewAdapter()
            adapter = horizontalViewAdapter

        }
    }

    private fun initViewModel() {
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getRecyclerListObserver()?.observe(this,Observer<PagedList<ResponseModelItem>>{
            if(it!=null){
                horizontalViewAdapter.submitList(it)
            }else{
                Toast.makeText(this,"Failed to fetch Data from the Server",Toast.LENGTH_SHORT).show()

            }
        })
    }
}