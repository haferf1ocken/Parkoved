package android.haferflocken.parkoved.ui.adapters

import android.haferflocken.parkoved.models.Ticket
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("ticketAttraction")
fun TextView.setTicketAttraction(item: Ticket) {
    item.let {
        text = item.service
    }
}

@BindingAdapter("ticketValidUntil")
fun TextView.setTicketValidUntil(item: Ticket) {
    item.let {
        text = item.validUntil
    }
}

@BindingAdapter("ticketAgeRestriction")
fun TextView.setTicketAgeRestriction(item: Ticket) {
    item.let {
        text = item.ageRestriction
    }
}

@BindingAdapter("ticketWorkTime")
fun TextView.setTicketWorkTime(item: Ticket) {
    item.let {
        text = item.expiresAt
    }
}

@BindingAdapter("ticketUsage")
fun TextView.setTicketUsage(item: Ticket) {
    item.let {
        text = item.uses.toString()
    }
}