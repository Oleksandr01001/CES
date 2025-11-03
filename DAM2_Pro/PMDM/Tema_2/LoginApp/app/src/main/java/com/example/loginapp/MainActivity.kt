package com.example.loginapp

import android.app.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonLogin.setOnClickListener { view ->
            val correo = binding.editCorreo.text.toString().trim()
            val contrasena = binding.editPass.text.toString().trim()

            if (correo.isEmpty() || contrasena.isEmpty()){
                Snackbar.make(view, "Introduce todos los datos", Snackbar.LENGTH_SHORT).show()
            } else if (correo == "admin" && contrasena == "admin"){
                Snackbar.make(view,"Has entrado correctamente", Snackbar.LENGTH_LONG).show()
            } else {
                Snackbar.make(view,"Los datos son incorrectos", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}