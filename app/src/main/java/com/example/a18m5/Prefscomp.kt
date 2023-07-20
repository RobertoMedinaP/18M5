package com.example.a18m5

import android.app.Application

class Prefscomp: Application() {
    companion object{
        lateinit var preferencias: Preferencias
    }


    override fun onCreate() {
        super.onCreate()
        preferencias= Preferencias(applicationContext)
    }
}

