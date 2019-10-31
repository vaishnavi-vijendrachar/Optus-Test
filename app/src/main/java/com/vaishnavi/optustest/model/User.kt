package com.vaishnavi.optustest.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(var name : String, var phone : String,var email : String,@PrimaryKey var id : Int ) {
}