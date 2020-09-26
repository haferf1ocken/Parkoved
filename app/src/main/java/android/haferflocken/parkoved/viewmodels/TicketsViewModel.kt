package android.haferflocken.parkoved.viewmodels

import android.app.Application
import android.haferflocken.parkoved.models.Ticket
import android.haferflocken.parkoved.repository.ParkovedRepository
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TicketsViewModel(application: Application) : AndroidViewModel(application) {

    private val attractions = listOf("Карусель", "Зона отдыха")
    private val validUntil = listOf("25/10/2020", "25/09/2020")
    private val ageRestriction = listOf("0+", "12+")
    private val workTime = listOf("10:00-20:00", "12:00-18:00")
    private val usage = listOf(1, 4)

    private val repository = ParkovedRepository.getInstance(application)

    private val _tickets = MutableLiveData<List<Ticket>>()
    val tickets: LiveData<List<Ticket>>
        get() = _tickets

    private var randomTickets = mutableListOf<Ticket>()

    fun fillTickets(): MutableList<Ticket> {
        for (i in 0L..5L) {
            val ticket =
                Ticket(i, attractions.random(), validUntil.random(), ageRestriction.random(),
                    workTime.random(), usage.random())
            randomTickets.add(ticket)
        }
        return randomTickets
    }

//    init {
//        getAllTickets()
//    }

    private fun getAllTickets() = viewModelScope.launch {
        _tickets.value = repository.getTickets()
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

