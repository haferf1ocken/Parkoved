package android.haferflocken.parkoved.repository

import android.haferflocken.parkoved.database.DatabaseTicket
import android.haferflocken.parkoved.models.Ticket
import androidx.lifecycle.LiveData

interface BaseRepository {
    suspend fun getTickets()

}