package android.haferflocken.parkoved.viewmodels

import android.app.Application
import android.haferflocken.parkoved.database.ParkovedDatabase
import android.haferflocken.parkoved.database.TicketDao
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TicketDetailViewModelFactory(
    private val ticketKey: Long,
    private val database: TicketDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TicketDetailViewModel::class.java)) {
            return TicketDetailViewModel(ticketKey, database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}