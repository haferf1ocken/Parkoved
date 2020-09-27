package android.haferflocken.parkoved.database

import android.haferflocken.parkoved.models.Ticket
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TicketDao {
    @Query("SELECT * FROM ticket")
    fun getTickets(): LiveData<List<Ticket>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg videos: Ticket)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ticket: Ticket)

    @Query("SELECT * FROM ticket WHERE ticketId = :key")
    fun getTicketWithId(key: Long): LiveData<Ticket>
}