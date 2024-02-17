/**..package com.example.mapaprueba.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mapaprueba.Lugares
import com.example.mapaprueba.R


class LugaresAdapter(private val listalugares:List<Lugares>) : RecyclerView.Adapter<LugaresHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LugaresHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return LugaresHolder(layoutInflater.inflate(R.layout.item_lugares, parent, false))
    }

    override fun getItemCount(): Int = listalugares.size


    override fun onBindViewHolder(holder: LugaresHolder, position: Int) {
        val item = listalugares[position]
        holder.render(item)
    }

}*/
package com.example.mapaprueba.adapter


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mapaprueba.LugarMorro
import com.example.mapaprueba.Lugares
import com.example.mapaprueba.R
/**..
class LugaresAdapter(private val listalugares:List<Lugares>) : RecyclerView.Adapter<LugaresHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LugaresHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return LugaresHolder(layoutInflater.inflate(R.layout.item_lugares, parent, false))
    }

    override fun getItemCount(): Int = listalugares.size


    override fun onBindViewHolder(holder: LugaresHolder, position: Int) {
        val item = listalugares[position]
        holder.render(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //private val textView: TextView = itemView.findViewById(R.id.Elnoseporque)
        private val imageView: ImageView = itemView.findViewById(R.id.Imagenparatal)
        private val tituloTextView: TextView = itemView.findViewById(R.id.Titulo)
        private val descripcionTextView: TextView = itemView.findViewById(R.id.Elnoseporque)

        fun bind(item: Lugares){
            itemView.setOnClickListener {
                imageView.setImageResource(item.imagen)
                tituloTextView.text = item.nombre
                descripcionTextView.text = item.coso

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, LugarMorro::class.java)
                    intent.putExtra("titulo", item.nombre)
                    intent.putExtra("descripcion", item.coso)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}*/

class LugaresAdapter(private val listalugares: List<Lugares>) : RecyclerView.Adapter<LugaresAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_lugares, parent, false))
    }

    override fun getItemCount(): Int = listalugares.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listalugares[position]
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.Imagenparatal)
        private val tituloTextView: TextView = itemView.findViewById(R.id.Titulo)
        private val descripcionTextView: TextView = itemView.findViewById(R.id.Elnoseporque)

        fun bind(item: Lugares) {
            imageView.setImageResource(item.imagen)
            tituloTextView.text = item.nombre
            descripcionTextView.text = item.coso

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, LugarMorro::class.java)
                intent.putExtra("titulo", item.nombre)
                intent.putExtra("descripcion", item.coso)
                intent.putExtra("imagen", item.imagen.toInt())
                itemView.context.startActivity(intent)
            }
        }
    }
}
