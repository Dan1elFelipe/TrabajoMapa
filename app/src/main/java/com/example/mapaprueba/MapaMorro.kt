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
    private var latitud: Double = 0.0
    private var longitud: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa_morro)

        latitud = intent.getDoubleExtra("latitud", 0.0)
        longitud = intent.getDoubleExtra("longitud", 0.0)

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
        val coordinates = LatLng(latitud, longitud)
        val marker = MarkerOptions().position(coordinates).title("Morro")
        mapMorro.addMarker(marker)
    }
}