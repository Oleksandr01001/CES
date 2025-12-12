package com.example.tienda.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tienda.R
import com.example.tienda.databinding.ItemProductoBinding
import com.example.tienda.dataset.DataSet
import com.example.tienda.model.Producto
import com.example.tienda.ui.activitys.DetalleActivity
import com.google.android.material.snackbar.Snackbar

class AdapterProducto(
    var lista: ArrayList<Producto>,
    private val contexto: Context
) : RecyclerView.Adapter<AdapterProducto.MyHolder>() {

    private var listener: OnProductoCarritoListener? = null

    init {
        if (contexto is OnProductoCarritoListener) {
            listener = contexto
        }
    }

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
                val builder = AlertDialog.Builder(contexto)
                builder.setTitle("Añadir al carrito")
                builder.setMessage("¿Seguro que quieres añadir \"${producto.nombre}\" al carrito?")

                builder.setPositiveButton("Sí") { _, _ ->
                    DataSet.addProducto(producto)

                    listener?.actualizarContadorCarrito()

                    Snackbar.make(
                        v,
                        "Producto añadido al carrito",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }

                builder.setNegativeButton("No") { dialog, _ ->
                    dialog.dismiss()
                }

                builder.show()
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
