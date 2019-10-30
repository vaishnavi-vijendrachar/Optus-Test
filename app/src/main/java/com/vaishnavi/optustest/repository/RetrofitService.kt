package com.vaishnavi.optustest.repository

import com.vaishnavi.optustest.data.Album
import com.vaishnavi.optustest.data.User
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService{
    @GET("/users")
    fun getUserDetails( ) : Call<List<User>>

    @GET("/photos")
    fun getPhotoAlbum() : Call<List<Album>>
}