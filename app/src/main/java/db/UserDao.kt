package db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vaishnavi.optustest.model.Album
import com.vaishnavi.optustest.model.User

@Dao
interface UserDao{
    @Query("SELECT * FROM User")
    abstract fun getUsers(): LiveData<List<User>>

    @Query("SELECT * FROM Album")
    abstract fun getAlbum(): LiveData<List<Album>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertUser(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAlbum(album: Album)
}