package android.haferflocken.parkoved.repository

import android.haferflocken.parkoved.models.Ticket

interface BaseRepository {
    suspend fun getTickets(): List<Ticket>
}