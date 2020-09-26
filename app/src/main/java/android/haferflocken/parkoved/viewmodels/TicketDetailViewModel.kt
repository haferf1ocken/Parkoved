package android.haferflocken.parkoved.viewmodels

import android.haferflocken.parkoved.models.Ticket
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TicketDetailViewModel(ticketKey: Long) : ViewModel() {

    private val ticket = MediatorLiveData<Ticket>()

    fun getTicket() = ticket

//    init {
//        ticket.addSource(database.getNightWithId(ticketKey), ticket::setValue)
//    }

    private val _navigateToSleepTracker = MutableLiveData<Boolean?>()

    val navigateToSleepTracker: LiveData<Boolean?>
        get() = _navigateToSleepTracker

    fun doneNavigating() {
        _navigateToSleepTracker.value = null
    }
}