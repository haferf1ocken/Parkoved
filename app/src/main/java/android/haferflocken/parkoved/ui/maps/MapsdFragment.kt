package android.haferflocken.parkoved.ui.maps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.haferflocken.parkoved.R
import android.haferflocken.parkoved.viewmodels.MapsViewModel

class MapsdFragment : Fragment() {

    private lateinit var mapsViewModel: MapsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mapsViewModel =
                ViewModelProviders.of(this).get(MapsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_maps, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        mapsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}