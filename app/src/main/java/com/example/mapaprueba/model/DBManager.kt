package com.example.mapaprueba.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.mapaprueba.Lugares

class DBManager(val context: Context) {

    lateinit var bd: SQLiteDatabase
    val bdHelper = BDHelper(context)

    fun openBdWr(){
        bd = bdHelper.writableDatabase
    }

    fun openBdRd(){
        bd = bdHelper.readableDatabase
    }

    fun insertarData(nombre: String, coso:String,  imagen: Int, latitud: Double, longitud:Double): Long{
        openBdWr()
        val contenedor = ContentValues()
        contenedor.put("nombre", nombre)
        contenedor.put("coso", coso)
        contenedor.put("imagen", imagen)
        contenedor.put("latitud", latitud)
        contenedor.put("longitud", longitud)

        return bd.insert("coordenadas", null, contenedor)
    }

}