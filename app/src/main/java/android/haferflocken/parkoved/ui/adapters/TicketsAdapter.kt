package android.haferflocken.parkoved.ui.adapters

import android.haferflocken.parkoved.databinding.ItemTicketsBinding
import android.haferflocken.parkoved.models.Ticket
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class TicketsAdapter(private val clickListener: TicketListener) :
    ListAdapter<Ticket, TicketViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Ticket>() {
        override fun areItemsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        return TicketViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        val ticketItem = getItem(position)
        holder.bind(ticketItem, clickListener)
    }
}

class TicketViewHolder private constructor(private val binding: ItemTicketsBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Ticket, clickListener: TicketListener) {
        binding.ticket = item
        binding.clickListener = clickListener
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): TicketViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemTicketsBinding.inflate(layoutInflater, parent, false)
            return TicketViewHolder(binding)
        }
    }
}

class TicketListener(val clickListener: (sleepId: Long) -> Unit) {
    fun onClick(ticket: Ticket) = clickListener(ticket.tid)
}