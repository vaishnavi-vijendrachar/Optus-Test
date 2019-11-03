package com.vaishnavi.optustest.photo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide.with
import com.vaishnavi.optustest.R
import com.vaishnavi.optustest.databinding.ActivityPhotosBinding
import com.vaishnavi.optustest.model.Photo
import kotlinx.android.synthetic.main.activity_photos.view.*

class PhotoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //data binding
        var binding : ActivityPhotosBinding = DataBindingUtil.setContentView(this,R.layout.activity_photos)

        //set up toolbar
        setSupportActionBar(binding.toolbar.toolbar)
        var bar : ActionBar? = getSupportActionBar()
        bar?.setDisplayHomeAsUpEnabled(true)
        bar?.setTitle(getString(R.string.photos))

        //get data from intent
        var intent : Intent =  getIntent()
        var intentUrl = intent.getStringExtra("url")
        var intentTitle = intent.getStringExtra("title")

        //var photo = findViewById<ImageView>(R.id.photo)
        //var title = findViewById<TextView>(R.id.title)


           /* with(applicationContext)
                .load(intentUrl)
                .centerCrop()
                .skipMemoryCache(false)
                .into(photo)
*/
        var photo = Photo(intentTitle,intentUrl)
        binding.photo = photo


    }
}