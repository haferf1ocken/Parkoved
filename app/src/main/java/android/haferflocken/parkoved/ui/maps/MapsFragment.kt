package android.haferflocken.parkoved.ui.maps

import android.haferflocken.parkoved.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*


class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        val park = LatLng(56.006832, 92.853113)
        val circle = LatLng(56.007844, 92.853983)
        val road = LatLng(56.008696, 92.855399)
        val tir = LatLng(56.008987, 92.852454)
        val katok = LatLng(56.008435, 92.8512954)

        googleMap.addMarker(MarkerOptions().position(circle).title("Колесо обозрения"))
        googleMap.addMarker(MarkerOptions().position(road).title("Железная дорога"))
        googleMap.addMarker(MarkerOptions().position(tir).title("Тир"))
        googleMap.addMarker(MarkerOptions().position(katok).title("Каток"))

        val cameraPosition = CameraPosition.Builder()
            .target(park)
            .zoom(16f)
            .build()
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}