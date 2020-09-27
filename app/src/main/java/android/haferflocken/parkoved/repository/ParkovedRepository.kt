package android.haferflocken.parkoved.repository

import android.app.Application
import android.haferflocken.parkoved.database.ParkovedDatabase
import android.haferflocken.parkoved.extensions.asDataBaseModel
import android.haferflocken.parkoved.models.Ticket
import android.haferflocken.parkoved.network.Network
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ParkovedRepository(
    private val application: Application,
    private val database: ParkovedDatabase)   {

    companion object {
        @Volatile
        private var INSTANCE: ParkovedRepository? = null

        fun getInstance(application: Application, database: ParkovedDatabase): ParkovedRepository {
            return INSTANCE ?: ParkovedRepository(application, database)
        }
    }

//    override suspend fun getTickets() = withContext(Dispatchers.IO) {
//        val _tickets = Network.parkoved.getTickets()
//        Log.d("ParkovedRepository", "getTickets: $_tickets")
//       database.ticketDao.insertAll(*_tickets.asDataBaseModel())
//    }
}