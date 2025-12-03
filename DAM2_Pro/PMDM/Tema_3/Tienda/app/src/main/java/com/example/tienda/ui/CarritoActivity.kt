package com.example.tienda.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tienda.adaptador.AdapterProducto
import com.example.tienda.databinding.ActivityCarritoBinding
import com.example.tienda.dataset.DataSet
import com.example.tienda.model.Producto

class CarritoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarritoBinding
    private lateinit var adapterCarrito: AdapterProducto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCarritoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Carrito"

        adapterCarrito = AdapterProducto(DataSet.listaCarrito, this)

        binding.recyclerCarrito.layoutManager = LinearLayoutManager(this)
        binding.recyclerCarrito.adapter = adapterCarrito

        actualizarTotal()

        binding.btnVaciarCarrito.setOnClickListener {
            DataSet.listaCarrito.clear()
            adapterCarrito.chageList(ArrayList<Producto>())
            actualizarTotal()
        }
    }

    private fun actualizarTotal() {
        var total = 0.0
        for (p in DataSet.listaCarrito) {
            total += p.precio
        }
        binding.textoTotalCarrito.text = "Total: %.2f €".format(total)
    }
}
