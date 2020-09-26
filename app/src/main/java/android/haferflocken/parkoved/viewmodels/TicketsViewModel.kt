package android.haferflocken.parkoved.viewmodels

import android.haferflocken.parkoved.models.Ticket
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TicketsViewModel : ViewModel() {

    private val attractions = listOf("Карусель", "Зона отдыха")
    private val validUntil = listOf("25/10/2020", "25/09/2020")
    private val ageRestriction = listOf("0+", "12+")
    private val workTime = listOf("10:00-20:00", "12:00-18:00")
    private val usage = listOf(1, 4)

    private var _tickets = mutableListOf<Ticket>()

    fun fillTickets(): MutableList<Ticket> {
        for (i in 0L..5L) {
            val ticket =
                Ticket(i, attractions.random(), validUntil.random(), ageRestriction.random(),
                    workTime.random(), usage.random())
            _tickets.add(ticket)
        }
        return _tickets
    }

    private val _navigateToTicketDataDetail = MutableLiveData<Long>()
    val navigateToTicketDataDetail: LiveData<Long>
        get() = _navigateToTicketDataDetail

    fun onTicketClicked(id: Long) {
        _navigateToTicketDataDetail.value = id
    }

    fun onTicketDetailDataNavigated() {
        _navigateToTicketDataDetail.value = null
    }
}

