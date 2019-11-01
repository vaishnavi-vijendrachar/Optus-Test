package com.vaishnavi.optustest.album

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vaishnavi.optustest.model.Album
import com.vaishnavi.optustest.repository.Repository

class AlbumViewModel() : ViewModel(){

    fun getAlbum(otherId : Int) : LiveData<List<Album>>{
        var list : MutableLiveData<List<Album>> = MutableLiveData()
        list = Repository.getAlbumFromNetwork(otherId) as MutableLiveData<List<Album>>
        return list
    }

}