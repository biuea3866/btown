package com.example.btown.Board

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.btown.Board.BoardFragment.Companion.LATITUDE
import com.example.btown.Board.BoardFragment.Companion.LOCATION_NAME
import com.example.btown.Board.BoardFragment.Companion.LONGITUDE
import com.example.btown.R
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import kotlinx.android.synthetic.main.activity_autocomplete.*
import java.util.*

class AutoCompleteFragment: Fragment(){
    var latitude : Double = 0.0
    var longitude :Double = 0.0
    lateinit var locationName: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate( R.layout.activity_autocomplete, container, false)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val apiKey = getString(R.string.google_places_key)

        if (!Places.isInitialized()) {
            Places.initialize(requireContext(), apiKey);
        }

        var autoCompleteFragment : AutocompleteSupportFragment =
            childFragmentManager.findFragmentById(R.id.autocomplete_fragment) as AutocompleteSupportFragment

        autoCompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.ADDRESS, Place.Field.LAT_LNG))
        autoCompleteFragment.setOnPlaceSelectedListener(object: PlaceSelectionListener{
            override fun onPlaceSelected(p0: Place) {
                // TODO("Not yet implemented")
                Log.i("Select place", p0.name +" " +p0.latLng)
                Log.d("", p0.address)
                val gmmIntentUri = Uri.parse("geo:${p0.latLng?.latitude},${p0.latLng?.longitude}")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)

                mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)

                latitude = p0.latLng?.latitude!!
                longitude = p0.latLng?.longitude!!
                locationName = p0.address!!

            }

            override fun onError(p0: Status) {
                //TODO("Not yet implemented")
                Log.i("error", " " + p0)
            }
        })

        back.setOnClickListener{
            var fragment = BoardFragment()
            var bundle = Bundle()

            bundle.putString(LOCATION_NAME, locationName)
            bundle.putDouble(LATITUDE, latitude)
            bundle.putDouble(LONGITUDE, longitude)

            fragment.arguments
        }
    }
}

/*
class AutoCompleteActivity: AppCompatActivity() {
    var latitude : Double = 0.0
    var longitude :Double = 0.0
    lateinit var locationName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autocomplete)
        val apiKey = getString(R.string.google_places_key)

        if (!Places.isInitialized()) {
            Places.initialize(getApplicationContext(), apiKey);
        }

        val placesClient = Places.createClient(this)
        var autoCompleteFragment : AutocompleteSupportFragment =
            supportFragmentManager.findFragmentById(R.id.autocomplete_fragment) as AutocompleteSupportFragment

        autoCompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.ADDRESS, Place.Field.LAT_LNG))
        autoCompleteFragment.setOnPlaceSelectedListener(object: PlaceSelectionListener{
            override fun onPlaceSelected(p0: Place) {
                // TODO("Not yet implemented")
                Log.i("Select place", p0.name +" " +p0.latLng)
                Log.d("", p0.address)
                val gmmIntentUri = Uri.parse("geo:${p0.latLng?.latitude},${p0.latLng?.longitude}")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)

                mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)

                latitude = p0.latLng?.latitude!!
                longitude = p0.latLng?.longitude!!
                locationName = p0.address!!

            }

            override fun onError(p0: Status) {

                Log.i("error", " " + p0)
            }
        })

        back.setOnClickListener{
            var fragment = BoardFragment()
            var bundle = Bundle()

            bundle.putString(LOCATION_NAME, locationName)
            bundle.putDouble(LATITUDE, latitude)
            bundle.putDouble(LONGITUDE, longitude)

            fragment.arguments
        }
    }
}*/