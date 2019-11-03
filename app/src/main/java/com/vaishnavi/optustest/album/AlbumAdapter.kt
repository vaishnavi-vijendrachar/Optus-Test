package com.vaishnavi.optustest.album

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.vaishnavi.optustest.model.Album
import com.vaishnavi.optustest.photo.PhotoActivity
import com.vaishnavi.optustest.R
import com.vaishnavi.optustest.databinding.AlbumItemBinding


class AlbumAdapter (val context : Context, val list: List<Album>, val albumid : Int) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>(){

    class AlbumViewHolder(albumBinding: AlbumItemBinding) : RecyclerView.ViewHolder(albumBinding.root){
        var albumItemBinding : AlbumItemBinding = albumBinding

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val albumBinding : AlbumItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.album_item,parent, false)
        return AlbumViewHolder(albumBinding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AlbumAdapter.AlbumViewHolder, position: Int) {
            holder.albumItemBinding.album = Album(list.get(position).albumId,list.get(position).id
                ,list.get(position).title,list.get(position).thumbnailUrl,list.get(position).url)
            holder.albumItemBinding.layout.setOnClickListener(View.OnClickListener {
                val intent = Intent(
                    holder.albumItemBinding.layout.context,
                    PhotoActivity::class.java
                )
                intent.putExtra("url",list.get(position).url)
                intent.putExtra("title",list.get(position).title)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                holder.albumItemBinding.layout.context.startActivity(intent)
            })
    }

}