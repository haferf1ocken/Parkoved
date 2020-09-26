package android.haferflocken.parkoved.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TicketDetailViewModelFactory(private val ticketKey: Long) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TicketDetailViewModel::class.java)) {
            return TicketDetailViewModel(ticketKey) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}