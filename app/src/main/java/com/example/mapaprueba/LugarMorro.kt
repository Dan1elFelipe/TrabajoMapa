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
    }

    fun funciondeltal(){
        elqueescucha()
    }

    fun elqueescucha(){
        binding.Cerrar.setOnClickListener{
            val intent = Intent(this, MainRecyclerView::class.java)
            startActivity(intent)
        }

        binding.Ubicacion.setOnClickListener{
            val intent = Intent(this, MapaMorro::class.java)
            startActivity(intent)
        }

    }




}