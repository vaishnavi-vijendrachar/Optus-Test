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

class AlbumAdapter (val context : Context, val list: List<Album>) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>(){

    class AlbumViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var image = itemView.findViewById<ImageView>(R.id.image)
        var title  = itemView.findViewById<TextView>(R.id.title)
        var layout = itemView.findViewById<LinearLayout>(R.id.layout)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumAdapter.AlbumViewHolder {
        var view : View = LayoutInflater.from(context).inflate(R.layout.album_item, parent, false)
        return AlbumAdapter.AlbumViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("vish","Adapter Size :"+list.size)
        return list.size
    }

    override fun onBindViewHolder(holder: AlbumAdapter.AlbumViewHolder, position: Int) {
       // holder.image.setText(list.get(position).name)
        //holder.title.setText(list.get(position).title)

        /*holder.layout.setOnClickListener(View.OnClickListener {
            val intent  = Intent(holder.layout.context,
                AlbumActivity::class.java)
            holder.layout.context.startActivity(intent)
        })*/
    }

}