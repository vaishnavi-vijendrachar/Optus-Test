package com.vaishnavi.optustest.main

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vaishnavi.optustest.R
import com.vaishnavi.optustest.album.AlbumActivity
import com.vaishnavi.optustest.model.User

class MainAdapter(val context : Context, val list: List<User>) : RecyclerView.Adapter<MainAdapter.UserViewHolder>(){

    class UserViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView){
            var name = itemView.findViewById<TextView>(R.id.name)
            var email  = itemView.findViewById<TextView>(R.id.email)
            var phone  = itemView.findViewById<TextView>(R.id.phone)
            var layout = itemView.findViewById<LinearLayout>(R.id.layout)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        var view : View = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("vish","Adapter Size :"+list.size)
        return list.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.name.setText(list.get(position).name)
        holder.email.setText(list.get(position).email)
        holder.phone.setText(list.get(position).phone)
        holder.layout.setOnClickListener(View.OnClickListener {
            val intent  = Intent(holder.layout.context,
                AlbumActivity::class.java)
            intent.putExtra("id",list.get(position).id)
            holder.layout.context.startActivity(intent)
        })
    }

}