package android.haferflocken.parkoved.ui.tickets.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.haferflocken.parkoved.R
import android.haferflocken.parkoved.database.ParkovedDatabase
import android.haferflocken.parkoved.databinding.FragmentTicketDetailBinding
import android.haferflocken.parkoved.viewmodels.TicketDetailViewModel
import android.haferflocken.parkoved.viewmodels.TicketDetailViewModelFactory
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

class TicketDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentTicketDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_ticket_detail, container, false)

        val application = requireNotNull(this.activity).application

        val arguments = TicketDetailFragmentArgs.fromBundle(requireArguments())
        val dataSource = ParkovedDatabase.getDatabase(application).ticketDao

        val ticketDetailViewModelFactory = TicketDetailViewModelFactory(arguments.ticketKey, dataSource)
        val ticketDetailViewModel = ViewModelProvider(this, ticketDetailViewModelFactory)
            .get(TicketDetailViewModel::class.java)

        binding.ticketDetailViewModel = ticketDetailViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }
}