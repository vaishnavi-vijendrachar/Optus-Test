package com.vaishnavi.optustest.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class Photo(var title: String, var url : String) {

    companion object {
    @BindingAdapter("url")
    @JvmStatic
    fun loadUrl(imageView: ImageView, url: String) {
        Glide.with(imageView.context)
            .load(url)
            .into(imageView)
    }}
}