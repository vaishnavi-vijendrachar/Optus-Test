package com.vaishnavi.optustest


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel() {
    lateinit var list : MutableLiveData<List<User>>
     fun getUserData() : LiveData<List<User>> {
         list = MutableLiveData()
         list = UserRepository.getUserDataFromNetwork() as MutableLiveData<List<User>>
         return list
     }
}