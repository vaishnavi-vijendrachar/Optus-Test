package com.vaishnavi.optustest.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.vaishnavi.optustest.MyApp
import com.vaishnavi.optustest.model.Album
import com.vaishnavi.optustest.model.User
import com.vaishnavi.optustest.repository.remote.RetrofitClient
import db.UserDatabase
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Integer.parseInt

class Repository {

    //override val coroutineContext: CoroutineContext = Dispatchers.Main + SupervisorJob()

    companion object {

        fun getUserDataFromNetwork(): LiveData<List<User>> {
            var userList = ArrayList<User>()
            var list = MutableLiveData<List<User>>()

            GlobalScope.launch {
                lateinit var user: User
                val call = RetrofitClient.getRetrofitInstance().getUserDetails()
                call.enqueue(object : Callback<List<User>> {
                    override fun onResponse(
                        call: Call<List<User>>,
                        response: Response<List<User>>
                    ) {
                        for (users: User in response.body()!!) {
                            user = User(
                                users.name,
                                users.phone,
                                users.email,
                                users.id
                            )
                            userList.add(user)
                           // saveUserToDB(user)
                            list.value = userList
                        }
                    }

                    override fun onFailure(call: Call<List<User>>, t: Throwable) {
                        t.printStackTrace()
                    }
                })
            }
            return list
        }

            fun getAlbumFromNetwork() : LiveData<List<Album>>  {
                var albumList = ArrayList<Album>()
                var list  = MutableLiveData<List<Album>>()
                GlobalScope.launch  {
                    val call = RetrofitClient.getRetrofitInstance().getPhotoAlbum()
                    call.enqueue(object : Callback<List<Album>> {
                        override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {

                            Log.d("vish","album response size :" + response.body()!!.size)

                            for (albums: Album in response.body()!!) {
                                    var album = Album(
                                        albums.albumId,
                                        albums.id,
                                        albums.title,
                                        albums.thumbnailUrl,
                                        albums.url
                                    )

                                    albumList.add(album)
                                    //saveAlbumToDB(album)
                                    list.value = albumList
                                    Log.d("vish", "albumlist response size :" + albumList.size)


                            }
                        }
                        override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                            t.printStackTrace()
                        }
                    })
                }
                 return list
            }

        private fun saveAlbumToDB(album: Album) {
          //  MyApp.database.insertAlbum(album)
            UserDatabase.getInstance(MyApp.context).userDao().insertAlbum(album)
        }

        private fun saveUserToDB(user: User) {
            //MyApp.database.insertUser(user)
            UserDatabase.getInstance(MyApp.context).userDao().insertUser(user)
        }


    }
}