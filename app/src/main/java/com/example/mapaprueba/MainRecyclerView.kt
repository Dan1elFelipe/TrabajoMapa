package com.example.mapaprueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mapaprueba.adapter.LugaresAdapter
import com.example.mapaprueba.databinding.ActivityMenuBinding

class MainRecyclerView : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecylcerView()
    }

    private fun initRecylcerView(){
        binding.RView.layoutManager = LinearLayoutManager(this)
        binding.RView.adapter = LugaresAdapter(LugaresProvider.lalista)
    }

}