package com.vaishnavi.optustest.album

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vaishnavi.optustest.model.Album
import kotlinx.android.synthetic.main.activity_main.toolbar

class AlbumActivity  : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.vaishnavi.optustest.R.layout.activity_album)

        //set up toolbar
        setSupportActionBar(toolbar)
        toolbar.setTitle("Album")

        //get data from intent
        var intent : Intent =  getIntent()
        var albumId = intent.getIntExtra("id",1)

        //set up recycler view
        val recyclerView = findViewById<RecyclerView>(com.vaishnavi.optustest.R.id.albumRecyclerView)
        recyclerView.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        //set Up ViewModel
        val viewModel : AlbumViewModel = ViewModelProviders.of(this)[AlbumViewModel::class.java]
        viewModel.getAlbum().observe(this, object : Observer<List<Album>> {
            override fun onChanged(list: List<Album>) {
                recyclerView.adapter = AlbumAdapter(applicationContext, list, albumId)
            }
        })

    }
}