package com.example.mapaprueba

import com.google.android.gms.maps.OnMapReadyCallback
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mapaprueba.databinding.ActivityMapaMorroBinding
import com.example.mapaprueba.model.DBManager
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapaMorro : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mapMorro: GoogleMap

    private var nombre: String = ""
    private var coso: String = ""
    private var imagen: Int = 0
    private var latitud: Double = 0.0
    private var longitud: Double = 0.0

    private lateinit var binding: ActivityMapaMorroBinding

    private lateinit var dbManager: DBManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapaMorroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbManager = DBManager(this)

        nombre = intent.getStringExtra("nombre") ?: "titulo"
        coso = intent.getStringExtra("coso") ?: "coso"
        imagen = intent.getIntExtra("imagen", 0)
        latitud = intent.getDoubleExtra("latitud", 0.0)
        longitud = intent.getDoubleExtra("longitud", 0.0)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapMorro) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mapMorro = googleMap
        createMarket()
    }

    private fun createMarket() {
        val coordinates = LatLng(latitud, longitud)
        val marker = MarkerOptions().position(coordinates).title("Morro")

        binding.btnMapa.setOnClickListener {
            dbManager.insertarData(nombre, coso,  imagen, latitud, longitud)
        }

        mapMorro.addMarker(marker)
    }
}