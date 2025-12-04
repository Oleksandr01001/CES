package com.example.tienda.adaptador

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tienda.R
import com.example.tienda.databinding.ItemProductoBinding
import com.example.tienda.dataset.DataSet
import com.example.tienda.model.Producto
import com.example.tienda.ui.DetalleActivity
import com.google.android.material.snackbar.Snackbar

class AdapterProducto(
    var lista: ArrayList<Producto>,
    private val contexto: Context
) : RecyclerView.Adapter<AdapterProducto.MyHolder>() {

    inner class MyHolder(val binding: ItemProductoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = ItemProductoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyHolder(binding)
    }

    override fun getItemCount(): Int = lista.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val producto = lista[position]

        with(holder.binding) {
            nombreFila.text = producto.nombre

            Glide.with(contexto)
                .load(producto.imagen)
                .placeholder(R.drawable.producto)
                .into(imagenFila)

            btnCompra.setOnClickListener { v ->
                DataSet.listaCarrito.add(producto)

                if (contexto is OnProductoCarritoListener) {
                    contexto.actualizarContadorCarrito()
                }

                Snackbar.make(v, "Producto añadido al carrito", Snackbar.LENGTH_SHORT).show()
            }

            btnDetalle.setOnClickListener {
                val intent = Intent(contexto, DetalleActivity::class.java)
                intent.putExtra("PRODUCTO", producto)
                contexto.startActivity(intent)
            }
        }
    }

    fun chageList(nuevaLista: ArrayList<Producto>) {
        lista = nuevaLista
        notifyDataSetChanged()
    }

    interface OnProductoCarritoListener {
        fun actualizarContadorCarrito()
    }
}
