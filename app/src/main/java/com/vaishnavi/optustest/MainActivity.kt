package com.vaishnavi.optustest

import android.os.Bundle


import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vaishnavi.optustest.data.User

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var mList : List<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        toolbar.setTitle("User Info")

        //set up recycler view
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        //set Up ViewModel
        val viewModel : MainViewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
        viewModel.getUserData().observe(this, object : Observer<List<User>> {
            override fun onChanged(list: List<User>) {
                recyclerView.adapter = UserAdapter(applicationContext, list)
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when(item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    /*fun getRetrofitStuff(): List<User>{
        var userList = ArrayList<User>()
        GlobalScope.launch {
            lateinit var user: User
            val call = RetrofitClient.getRetrofitInstance().getUserDetails()
            call.enqueue(object : Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    Log.d("vish", "Retrofit Response: " + response.body()?.size)
                    for(users : User in response.body()!!){
                        user = User(users.name,users.phone,users.email,users.id)
                        userList.add(users)
                    }
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    t.printStackTrace()
                }
            })
        }
        return userList
    }*/
}
