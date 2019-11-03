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

    lateinit var viewModel : AlbumViewModel
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
        setUpViewModel(binding, albumId)

        //set up refresh button
        setUpRefresh(binding,albumId)

        //fetch data
        fetchData(binding,albumId,viewModel )

    }

    private fun setUpRefresh(binding: ActivityAlbumBinding, albumId: Int) {
        binding.swipe.setColorSchemeColors(resources.getColor(R.color.colorAccent))
        binding.swipe.setOnRefreshListener {
            fetchData(binding,albumId,viewModel ) //refresh list
        }
    }
    private fun setUpViewModel(binding: ActivityAlbumBinding , albumId: Int) {
        viewModel = ViewModelProviders.of(this)[AlbumViewModel::class.java]
        fetchData(binding,albumId,viewModel)

    }

    private fun fetchData(binding : ActivityAlbumBinding, albumId: Int, viewModel: AlbumViewModel) {
        binding.swipe.setRefreshing(true)
        if(NetworkUtil.checkNetworkAvilablility(this)) {
            viewModel.getAlbum(albumId).observe(this, object : Observer<List<Album>> {
                override fun onChanged(list: List<Album>) {
                    binding.albumRecyclerView.adapter = AlbumAdapter(applicationContext, list, albumId)
                    binding.swipe.setRefreshing(false)
                }
            })
        }else{
            Toast.makeText(applicationContext,getString(R.string.no_network),Toast.LENGTH_SHORT).show()
            binding.swipe.setRefreshing(false)
        }
    }


}