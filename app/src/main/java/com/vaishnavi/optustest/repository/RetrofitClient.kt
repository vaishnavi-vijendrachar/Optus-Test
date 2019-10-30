package com.vaishnavi.optustest.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        fun getRetrofitInstance(): RetrofitService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

            return retrofit.create(RetrofitService::class.java)
        }
    }
}