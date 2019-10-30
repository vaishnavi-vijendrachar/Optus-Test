package com.vaishnavi.optustest

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService{
    @GET("/users")
    fun getUserDetails( ) : Call<List<User>>
}