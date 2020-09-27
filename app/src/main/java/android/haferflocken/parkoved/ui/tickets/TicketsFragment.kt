package android.haferflocken.parkoved.ui.tickets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.haferflocken.parkoved.R
import android.haferflocken.parkoved.database.ParkovedDatabase
import android.haferflocken.parkoved.databinding.FragmentTicketsBinding
import android.haferflocken.parkoved.ui.adapters.TicketListener
import android.haferflocken.parkoved.ui.adapters.TicketsAdapter
import android.haferflocken.parkoved.viewmodels.TicketDetailViewModelFactory
import android.haferflocken.parkoved.viewmodels.TicketsViewModel
import android.haferflocken.parkoved.viewmodels.TicketsViewModelFactory
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

class TicketsFragment : Fragment() {

    private lateinit var ticketsViewModel: TicketsViewModel
    //private lateinit var ticketsViewModelFactory: TicketsViewModelFactory

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentTicketsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_tickets, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = ParkovedDatabase.getDatabase(application).ticketDao

        //ticketsViewModelFactory = TicketsViewModelFactory(application, dataSource)
        ticketsViewModel = ViewModelProvider(this).get(TicketsViewModel::class.java)
        binding.viewModel = ticketsViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = TicketsAdapter(TicketListener { ticketId ->
            ticketsViewModel.onTicketClicked(ticketId)
        })

        adapter.submitList(ticketsViewModel.fillTickets())
        binding.rvTickets.adapter = adapter

        ticketsViewModel.navigateToTicketDataDetail.observe(viewLifecycleOwner) { ticket ->
            ticket?.let {
                this.findNavController().navigate(
                    TicketsFragmentDirections
                        .actionNavigationTicketsToTicketDetailFragment(ticket)
                )
                ticketsViewModel.onTicketDetailDataNavigated()
            }
        }

        binding.floatingActionButton.setOnClickListener {
            it.let {
                this.findNavController().navigate(
                    TicketsFragmentDirections.actionNavigationTicketsToNavigationMaps()
                )
            }
        }

        return binding.root
    }
}