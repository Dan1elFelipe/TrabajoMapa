package com.example.mapaprueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.mapaprueba.databinding.ActivityLugarMorroBinding

class LugarMorro : AppCompatActivity() {

    lateinit var binding: ActivityLugarMorroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLugarMorroBinding.inflate((LayoutInflater.from(this)))
        setContentView(binding.root)

        funciondeltal()
        loaddata()
    }

    fun loaddata(){
        val name = intent.getStringExtra("titulo")
        val descripcion = intent.getStringExtra("descripcion")
        val image = intent.getIntExtra("imagen", 0)

        binding.TituloLugar.text = name
        binding.Descripcion.text = descripcion
        binding.ImagenLugar.setImageResource(image)
    }

    fun funciondeltal(){
        elqueescucha()
    }

    private fun elqueescucha(){
        binding.Cerrar.setOnClickListener{
            val intent = Intent(this, MainRecyclerView::class.java)
            startActivity(intent)
        }

        binding.Ubicacion.setOnClickListener{
            val latitud = intent.getDoubleExtra("latitud", 0.0)
            val longitud = intent.getDoubleExtra("longitud", 0.0)

            val intent = Intent(this, MapaMorro::class.java).apply {
                putExtra("latitud", latitud)
                putExtra("longitud", longitud)
            }
            startActivity(intent)
        }
    }
}