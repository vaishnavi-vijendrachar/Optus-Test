package com.vaishnavi.optustest


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vaishnavi.optustest.data.User
import com.vaishnavi.optustest.repository.Repository


class MainViewModel : ViewModel() {

     fun getUserData() : LiveData<List<User>> {
         var list : MutableLiveData<List<User>> = MutableLiveData()
         list = Repository.getUserDataFromNetwork() as MutableLiveData<List<User>>
         return list
     }

}