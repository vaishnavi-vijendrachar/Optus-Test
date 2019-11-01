package com.vaishnavi.optustest.album

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vaishnavi.optustest.R
import com.vaishnavi.optustest.databinding.ActivityAlbumBinding
import com.vaishnavi.optustest.model.Album
import kotlinx.android.synthetic.main.activity_album.view.*
import kotlinx.android.synthetic.main.activity_main.toolbar

class AlbumActivity  : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Data binding
        var binding : ActivityAlbumBinding = DataBindingUtil.setContentView(this,R.layout.activity_album)

        //set up toolbar
        setSupportActionBar(binding.toolbar.toolbar)
        binding.toolbar.setTitle("Album")

        //get data from intent
        var intent : Intent =  getIntent()
        var albumId = intent.getIntExtra("id",1)

        //set up recycler view
        val recyclerView : RecyclerView = binding.albumRecyclerView
        recyclerView.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        //set Up ViewModel
        val viewModel : AlbumViewModel = ViewModelProviders.of(this)[AlbumViewModel::class.java]
        viewModel.getAlbum(albumId).observe(this, object : Observer<List<Album>> {
            override fun onChanged(list: List<Album>) {
                recyclerView.adapter = AlbumAdapter(applicationContext, list, albumId)
            }
        })

    }
}