package com.vaishnavi.optustest.album

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vaishnavi.optustest.model.Album
import com.vaishnavi.optustest.repository.Repository

class AlbumViewModel : ViewModel(){

    fun getAlbum() : LiveData<List<Album>>{
        var list : MutableLiveData<List<Album>> = MutableLiveData()
        list = Repository.getAlbumFromNetwork() as MutableLiveData<List<Album>>
        return list
    }
}