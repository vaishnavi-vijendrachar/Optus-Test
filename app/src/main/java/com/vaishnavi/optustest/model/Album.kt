package com.vaishnavi.optustest.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Album(@PrimaryKey var albumId : Int, var id : Int, var title: String, var url : String, var thumbnailUrl : String){
}