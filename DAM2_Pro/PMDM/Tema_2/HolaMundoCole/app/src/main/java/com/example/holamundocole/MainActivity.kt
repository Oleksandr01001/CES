package com.example.holamundocole

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v("ciclo_vida","Ejecutando metodo onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.v("ciclo_vida","Ejecutando metodo onStart")

    }

    override fun onRestart() {
        super.onRestart()
        Log.v("ciclo_vida","Ejecutando metodo onRestart")

    }

    override fun onResume() {
        super.onResume()
        Log.v("ciclo_vida","Ejecutando metodo onResume")

    }

    override fun onStop() {
        super.onStop()
        Log.v("ciclo_vida","Ejecutando metodo onStop")

    }

    override fun onPause() {
        super.onPause()
        Log.v("ciclo_vida","Ejecutando metodo onPause")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ciclo_vida","Ejecutando metodo onDestroy")

    }




}