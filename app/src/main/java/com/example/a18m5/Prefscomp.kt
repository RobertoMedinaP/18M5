package com.example.a18m5

import android.annotation.SuppressLint
import android.app.Application

class Prefscomp: Application() {

    companion object{
         var preferencias: Preferencias?=null
    }


    override fun onCreate() {

        preferencias= Preferencias(applicationContext)
        super.onCreate()
    }
}

