package com.example.mapaprueba

import com.google.android.gms.maps.OnMapReadyCallback
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapaMorro : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mapMorro: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa_morro)

        createFragment()

    }

    private fun createFragment(){
        val mapFragment: SupportMapFragment = supportFragmentManager.findFragmentById(R.id.mapMorro) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mapMorro = googleMap
        createMarket()
    }

    private fun createMarket() {
        val coordinates = LatLng(2.44474, -76.60007)
        val marker = MarkerOptions().position(coordinates).title("Morro")
        mapMorro.addMarker(marker)
    }
}