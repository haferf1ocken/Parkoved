package android.haferflocken.parkoved.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

//@Dao
//interface ServiceDao {
//    @Query("SELECT * FROM databaseservice")
//    fun getServices(): LiveData<List<DatabaseService>>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertAll(vararg videos: DatabaseService)
//
//    @Query("SELECT * FROM databaseservice WHERE sid = :key")
//    suspend fun getService(key: String): DatabaseService
//}