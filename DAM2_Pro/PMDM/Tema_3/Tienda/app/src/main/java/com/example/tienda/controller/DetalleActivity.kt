package com.example.tienda.controller

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tienda.R
import com.example.tienda.databinding.ActivityDetalleBinding
import com.example.tienda.model.Producto

class DetalleActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetalleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val producto = intent.getSerializableExtra("producto") as Producto

        binding.tvNombre.text = producto.nombre
        binding.tvPrecio.text = producto.precio.toString()
        binding.tvStock.text = producto.stock.toString()
        binding.tvDescripcion.text = producto.descripcion

    }
}