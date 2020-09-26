package android.haferflocken.parkoved.ui.adapters

import android.haferflocken.parkoved.databinding.ItemEventsBinding
import android.haferflocken.parkoved.models.Event
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class EventsAdapter(private val clickListener: EventsListener) :
    ListAdapter<Event, EventsViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Event>() {
        override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsViewHolder {
        return EventsViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: EventsViewHolder, position: Int) {
        val eventItem = getItem(position)
        holder.bind(eventItem, clickListener)
    }
}

class EventsViewHolder private constructor(private val binding: ItemEventsBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Event, clickListener: EventsListener) {
        binding.event = item
        binding.clickListener = clickListener
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): EventsViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemEventsBinding.inflate(layoutInflater, parent, false)
            return EventsViewHolder(binding)
        }
    }
}

class EventsListener(val clickListener: (sleepId: Long) -> Unit) {
    fun onClick(event: Event) = clickListener(event.eventId)
}