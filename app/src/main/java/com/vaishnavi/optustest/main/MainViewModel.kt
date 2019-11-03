package com.vaishnavi.optustest.main


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vaishnavi.optustest.model.User
import com.vaishnavi.optustest.repository.Repository
import kotlinx.coroutines.CoroutineScope
import org.jetbrains.annotations.TestOnly


class MainViewModel : ViewModel() {

     fun getUserData() : LiveData<List<User>> {
         var list : MutableLiveData<List<User>> = MutableLiveData()
         list = Repository.getUserDataFromNetwork() as MutableLiveData<List<User>>
         return list
     }

}