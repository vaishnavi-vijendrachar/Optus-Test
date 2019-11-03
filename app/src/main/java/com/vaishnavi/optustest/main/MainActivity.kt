package com.vaishnavi.optustest.main

import android.os.Bundle


import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vaishnavi.optustest.R
import com.vaishnavi.optustest.album.NetworkUtil
import com.vaishnavi.optustest.databinding.ActivityMainBinding
import com.vaishnavi.optustest.model.User
import kotlinx.android.synthetic.main.activity_main.*


import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //set up data binding
        var binding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        //setUp Action bar
        setUpActionBar(binding)

        //set up recycler view
        val recyclerView : RecyclerView = binding.recyclerView
        recyclerView.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        //set Up ViewModel and observe live data
        if(NetworkUtil.checkNetworkAvilablility(this)) {
            setUpViewModel(recyclerView)
        }else{
            Toast.makeText(applicationContext,"No Network Connection!",Toast.LENGTH_SHORT).show()
        }

    }

    private fun setUpViewModel(recyclerView: RecyclerView) {
        val viewModel : MainViewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
        viewModel.getUserData().observe(this, object : Observer<List<User>> {
            override fun onChanged(list: List<User>) {
                //set adapter to recycler view
                recyclerView.adapter =
                    MainAdapter(applicationContext, list)
            }
        })
    }

    private fun setUpActionBar(binding: ActivityMainBinding) {
        setSupportActionBar(binding.toolbar.toolbar)
        var bar : ActionBar? = getSupportActionBar()
        bar?.setDisplayShowHomeEnabled(true)
        bar?.setTitle(getString(R.string.user_info))
    }
}
