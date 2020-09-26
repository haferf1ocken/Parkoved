package android.haferflocken.parkoved.ui.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import android.haferflocken.parkoved.R
import android.haferflocken.parkoved.databinding.FragmentEventsBinding
import android.haferflocken.parkoved.ui.adapters.EventsAdapter
import android.haferflocken.parkoved.ui.adapters.EventsListener
import android.haferflocken.parkoved.ui.adapters.StoriesAdapter
import android.haferflocken.parkoved.ui.adapters.StoriesListener
import android.haferflocken.parkoved.viewmodels.EventsViewModel
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

class EventsFragment : Fragment() {

    private lateinit var eventsViewModel: EventsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentEventsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_events, container, false)

        val application = requireNotNull(this.activity).application

        eventsViewModel = ViewModelProvider(this).get(EventsViewModel::class.java)

        val storiesAdapter = StoriesAdapter(StoriesListener { storyId ->
            Toast.makeText(application.applicationContext, "$storyId", Toast.LENGTH_SHORT).show()
        })

        binding.rvStories.adapter = storiesAdapter
        storiesAdapter.submitList(eventsViewModel.fillStories())

        val eventsAdapter = EventsAdapter(EventsListener { eventId ->
            Toast.makeText(application.applicationContext, "$eventId", Toast.LENGTH_SHORT).show()
        })

        binding.rvEvents.adapter = eventsAdapter
        eventsAdapter.submitList(eventsViewModel.fillEvents())

        return binding.root
    }
}