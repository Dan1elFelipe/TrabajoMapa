package com.example.mapaprueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapaParque : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mapParque: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa_parque)

        createFragment()
    }

    private fun createFragment(){
        val mapFragment: SupportMapFragment = supportFragmentManager.findFragmentById(R.id.mapParque) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mapParque = googleMap
        createMarket()
    }

    private fun createMarket() {
        val coordinates = LatLng(2.44214, -76.60632)
        val marker = MarkerOptions().position(coordinates).title("Parque Caldas")
        mapParque.addMarker(marker)
    }
}