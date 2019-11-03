/*
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.vaishnavi.optustest.model.Album
import com.vaishnavi.optustest.model.User
import com.vaishnavi.optustest.repository.remote.RetrofitClient
import com.vaishnavi.optustest.repository.remote.RetrofitService
import kotlinx.coroutines.CoroutineScope
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumDataSource () : PageKeyedDataSource<Int, Album>() {

    var userList = ArrayList<User>()
    var list = MutableLiveData<List<User>>()

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Album>) {
        var albumList = ArrayList<Album>()
        var list  = MutableLiveData<List<Album>>()
        val call = RetrofitClient.getRetrofitInstance().getPhotoAlbum()
        call.enqueue(object : Callback<List<Album>> {
            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                for (albums: Album in response.body()!!) {
                    var album = Album(
                        albums.albumId,
                        albums.id,
                        albums.title,
                        albums.thumbnailUrl,
                        albums.url
                    )

                    albumList.add(album)
                    list.value = albumList

                }

                callback.onResult(albumList,null,2)
            }
            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Album>) {
        var albumList = ArrayList<Album>()
        var list  = MutableLiveData<List<Album>>()
        val call = RetrofitClient.getRetrofitInstance().getPhotoAlbum(params.key,30)
        call.enqueue(object : Callback<List<Album>> {
            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {

                val page = params.key
                for (albums: Album in response.body()!!) {
                    var album = Album(
                        albums.albumId,
                        albums.id,
                        albums.title,
                        albums.thumbnailUrl,
                        albums.url
                    )

                    albumList.add(album)
                    //saveAlbumToDB(album)
                    list.value = albumList
                    Log.d("vish", "albumlist response size :" + albumList.size)
                }

                callback.onResult(albumList,page+1)
            }
            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Album>) {

    }

}*/
