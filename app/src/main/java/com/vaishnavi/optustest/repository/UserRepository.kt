package com.vaishnavi.optustest.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vaishnavi.optustest.data.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository{


    companion object {

        fun getUserDataFromNetwork(): LiveData<List<User>> {
            var userList = ArrayList<User>()
            var list  = MutableLiveData<List<User>>()

            GlobalScope.launch {
                lateinit var user: User
                val call = RetrofitClient.getRetrofitInstance().getUserDetails()
                call.enqueue(object : Callback<List<User>> {
                    override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
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
    }
}