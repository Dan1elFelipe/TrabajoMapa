package com.example.mapaprueba.adapter


import android.content.Context
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mapaprueba.LugarMorro
import com.example.mapaprueba.Lugares
import com.example.mapaprueba.databinding.ItemLugaresBinding

class LugaresHolder(view: View):RecyclerView.ViewHolder(view) {

    val binding = ItemLugaresBinding.bind(view)

    fun render(lugaresModel: Lugares){
        binding.Titulo.text = lugaresModel.nombre
        binding.Elnoseporque.text = lugaresModel.coso
        Glide.with(binding.Imagenparatal.context).load(lugaresModel.imagen).into(binding.Imagenparatal)
        binding.root.setOnClickListener{

            //Toast.makeText(
            //    binding.Imagenparatal.context,
            //    lugaresModel.nombre,
            //    Toast.LENGTH_SHORT
            //).show()

        }

    }

}
