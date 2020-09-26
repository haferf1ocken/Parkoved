package android.haferflocken.parkoved.repository

import android.app.Application
import android.haferflocken.parkoved.models.Ticket
import android.haferflocken.parkoved.network.Network

class ParkovedRepository(application: Application) : BaseRepository {

    companion object {
        @Volatile
        private var INSTANCE: ParkovedRepository? = null

        fun getInstance(application: Application): ParkovedRepository {
            return INSTANCE ?: ParkovedRepository(application)
        }
    }

    override suspend fun getTickets(): List<Ticket> = Network.parkoved.getTickets()

}