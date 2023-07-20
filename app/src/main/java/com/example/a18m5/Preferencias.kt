package com.example.a18m5

import android.content.Context

class Preferencias(val context: Context) {

    val nombrepreferencias="Misdatos"
    private val guardado= context.getSharedPreferences(nombrepreferencias,0)


    fun guardardatos(llave: String, dato: String){
        guardado.edit().putString(llave,dato).apply()
    }

    fun obtenerdatos(llave: String): String?{
        return guardado.getString(llave, null)
    }

    fun borrardatos(llave: String){
        guardado.edit().remove(llave).apply()
    }

}