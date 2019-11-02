package com.vaishnavi.optustest.main

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.vaishnavi.optustest.R
import com.vaishnavi.optustest.album.AlbumActivity
import com.vaishnavi.optustest.databinding.ListItemBinding
import com.vaishnavi.optustest.model.User

class MainAdapter(val context : Context, val list: List<User>) : RecyclerView.Adapter<MainAdapter.UserViewHolder>(){

    class UserViewHolder(listBinding: ListItemBinding) : RecyclerView.ViewHolder(listBinding.root){
            var listItemBinding : ListItemBinding = listBinding //set up view holder

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        //set up adapter
        var listBinding : ListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.list_item,parent, false)
        return UserViewHolder(listBinding)
    }

    override fun getItemCount(): Int {
        return list.size //get the size of the list
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        //bind view to data
        holder.listItemBinding.user = User(list.get(position).name,list.get(position).email,list.get(position).phone,list.get(position).id)
        holder.listItemBinding.layout.setOnClickListener { //to enable item click
            val intent  = Intent(holder.listItemBinding.layout.context,
                AlbumActivity::class.java)
            intent.putExtra("id",list.get(position).id)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            holder.listItemBinding.layout.context.startActivity(intent)
        }
    }

}