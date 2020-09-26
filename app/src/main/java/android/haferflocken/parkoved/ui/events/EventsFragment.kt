package android.haferflocken.parkoved.ui.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import android.haferflocken.parkoved.R
import android.haferflocken.parkoved.viewmodels.EventsViewModel
import androidx.lifecycle.ViewModelProvider

class EventsFragment : Fragment() {

    private lateinit var eventsViewModel: EventsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        eventsViewModel = ViewModelProvider(this).get(EventsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_events, container, false)
        return root
    }
}