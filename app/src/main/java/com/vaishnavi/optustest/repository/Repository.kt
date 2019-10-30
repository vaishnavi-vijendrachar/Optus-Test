package com.vaishnavi.optustest.repository

import android.os.Handler
import android.util.Log
import androidx.core.os.postDelayed
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vaishnavi.optustest.data.Album
import com.vaishnavi.optustest.data.User
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

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
                           // var album = Album(1,1,"accusamus beatae ad facilis cum similique qui sunt","https://via.placeholder.com/600/92c95","https://via.placeholder.com/150/92c952")
                                    albumList.add(album)
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

        private fun launch(function: () -> Unit) {

        }
    }
}