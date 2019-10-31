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
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.vaishnavi.optustest.model.Album
import com.vaishnavi.optustest.PhotoActivity


class AlbumAdapter (val context : Context, val list: List<Album>, val albumid : Int) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>(){

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
        return list.size
    }

    override fun onBindViewHolder(holder: AlbumAdapter.AlbumViewHolder, position: Int) {
        if(list.get(position).albumId == albumid ) {
            holder.title.setText(list.get(position).title)
            //using glide libary to load the images efficiently
            Glide.with(context)
                .load(list.get(position).thumbnailUrl)
                .centerCrop()
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(holder.image)
            holder.layout.setOnClickListener(View.OnClickListener {
                val intent = Intent(
                    holder.layout.context,
                    PhotoActivity::class.java
                )
                intent.putExtra("url",list.get(position).url)
                intent.putExtra("title",list.get(position).title)
                holder.layout.context.startActivity(intent)
            })

        }
    }

}