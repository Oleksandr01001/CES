package com.example.tienda.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.tienda.R
import com.example.tienda.databinding.ActivityDetalleBinding
import com.example.tienda.model.Producto

class DetalleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val producto = intent.getSerializableExtra("PRODUCTO") as? Producto

        if (producto != null) {
            title = producto.nombre

            binding.textoNombreDetalle.text = producto.nombre
            binding.textoPrecioDetalle.text = "${producto.precio} €"
            binding.textoStockDetalle.text = "Stock: ${producto.stock}"
            binding.textoDescripcionDetalle.text = producto.descripcion

            Glide.with(this)
                .load(producto.imagen)
                .placeholder(R.drawable.producto)
                .into(binding.imagenDetalle)
        }
    }
}
