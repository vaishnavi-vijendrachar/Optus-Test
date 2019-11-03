package com.vaishnavi.optustest.album

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo


class NetworkUtil {
    companion object{
        fun checkNetworkAvilablility(context: Context) : Boolean{
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
            val isConnected: Boolean = activeNetwork?.isConnected == true
            return isConnected
        }
    }
}