package com.vaishnavi.optustest.album

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vaishnavi.optustest.R
import com.vaishnavi.optustest.UserAdapter
import com.vaishnavi.optustest.data.Album
import com.vaishnavi.optustest.data.User
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.os.Handler
import com.vaishnavi.optustest.PhotoActivity

import retrofit2.http.Url
import java.net.URL


class AlbumAdapter (val context : Context, val list: List<Album>) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>(){

    class AlbumViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var image = itemView.findViewById<ImageView>(com.vaishnavi.optustest.R.id.image)
        var title  = itemView.findViewById<TextView>(com.vaishnavi.optustest.R.id.title)
        var layout = itemView.findViewById<LinearLayout>(com.vaishnavi.optustest.R.id.layout)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumAdapter.AlbumViewHolder {
        var view : View = LayoutInflater.from(context).inflate(com.vaishnavi.optustest.R.layout.album_item, parent, false)
        return AlbumAdapter.AlbumViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("vish","Album Adapter Size :"+list.size)
        return list.size
    }

    override fun onBindViewHolder(holder: AlbumAdapter.AlbumViewHolder, position: Int) {
       // holder.image.setText(list.get(position).image)
        holder.title.setText(list.get(position).title)
        /*var url : URL = URL(list.get(position).thumbnailUrl)
        var handler : Handler = Handler()
        handler.postDelayed(Runnable{
            var bitmap : Bitmap  = BitmapFactory.decodeStream(url. openConnection().getInputStream());
            holder.image.setImageBitmap(bitmap)
        },1000)*/


        holder.layout.setOnClickListener(View.OnClickListener {
            val intent  = Intent(holder.layout.context,
                PhotoActivity::class.java)
            holder.layout.context.startActivity(intent)
        })


    }

}