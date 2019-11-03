package com.vaishnavi.optustest.album

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
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

class AlbumActivity  : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Data binding
        val binding : ActivityAlbumBinding = DataBindingUtil.setContentView(this,R.layout.activity_album)

        //set up toolbar
        setSupportActionBar(binding.toolbar.toolbar)
        var bar : ActionBar? = getSupportActionBar()
        bar?.setDisplayHomeAsUpEnabled(true)
        bar?.setTitle(getString(R.string.album))

        //get data from intent
        var intent : Intent =  getIntent()
        var albumId = intent.getIntExtra("id",1)

        //set up recycler view
        val recyclerView : RecyclerView = binding.albumRecyclerView
        recyclerView.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)


        //set Up ViewModel and observe live data
        if(NetworkUtil.checkNetworkAvilablility(this)) {
            setUpViewModel(recyclerView, albumId)
        }else{
            Toast.makeText(applicationContext,"No Network Connection!", Toast.LENGTH_SHORT).show()
        }

    }

    private fun setUpViewModel(recyclerView: RecyclerView, albumId: Int) {
        val viewModel : AlbumViewModel = ViewModelProviders.of(this)[AlbumViewModel::class.java]
        viewModel.getAlbum(albumId).observe(this, object : Observer<List<Album>> {
            override fun onChanged(list: List<Album>) {
                recyclerView.adapter = AlbumAdapter(applicationContext, list, albumId)
            }
        })
    }


}