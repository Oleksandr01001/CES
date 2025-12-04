package com.example.practicapsp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practicapsp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val usuario = binding.editUsuario.text.toString().trim()
            val contrasena = binding.editContrasena.text.toString().trim()

            val cliente = TCPCliente()
            cliente.enviarLogin(usuario, contrasena) { result ->

                when (result) {
                    "OK" -> Toast.makeText(this, "Login correcto", Toast.LENGTH_SHORT).show()
                    "ERROR" -> Toast.makeText(this, "Login incorrecto", Toast.LENGTH_SHORT).show()
                    else -> Toast.makeText(this, "Error de conexión", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}
