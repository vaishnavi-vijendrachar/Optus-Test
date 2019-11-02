package com.vaishnavi.optustest.repository.remote

import com.vaishnavi.optustest.model.Album
import com.vaishnavi.optustest.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService{
    @GET("/users")
    fun getUserDetails( ) : Call<List<User>>

    @GET("/photos")
    fun getPhotoAlbum() : Call<List<Album>>

}