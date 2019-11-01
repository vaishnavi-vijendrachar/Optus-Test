package com.vaishnavi.optustest.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bumptech.glide.Glide

@Entity
class Album(@PrimaryKey var albumId : Int, var id : Int, var title: String, var url : String, var thumbnailUrl : String){

    companion object {
        @BindingAdapter("thumbnailUrl")
        @JvmStatic
        fun loadImage(imageView: ImageView, url: String) {
            Glide.with(imageView.context)
                .load(url)
                .into(imageView)
        }

    }
}