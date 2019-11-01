package com.vaishnavi.optustest.photo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.vaishnavi.optustest.R

class PhotoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)
     /*   setSupportActionBar(toolbar)
        toolbar.setTitle("Photos")*/

        //get data from intent
        var intent : Intent =  getIntent()
        var url = intent.getStringExtra("url")
        var intentTitle = intent.getStringExtra("title")

        var photo = findViewById<ImageView>(R.id.photo)
        var title = findViewById<TextView>(R.id.title)


            Glide.with(applicationContext)
                .load(url)
                .centerCrop()
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(photo)


        title.setText(intentTitle)
    }
}