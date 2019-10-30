package com.vaishnavi.optustest.repository

import com.vaishnavi.optustest.data.User
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService{
    @GET("/users")
    fun getUserDetails( ) : Call<List<User>>
}