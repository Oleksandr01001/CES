package com.example.agendajson.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.agendajson.R
import com.example.agendajson.model.User

class UserAdapter(
    private val lista: List<User>,
    private val onClick: (User) -> Unit
) : RecyclerView.Adapter<UserAdapter.VH>() {

    class VH(v: View) : RecyclerView.ViewHolder(v) {
        val tvNombre: TextView = v.findViewById(R.id.tvNombre)
        val tvEmail: TextView = v.findViewById(R.id.tvEmail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val user = lista[position]
        holder.tvNombre.text = "${user.firstName.orEmpty()} ${user.lastName.orEmpty()}"
        holder.tvEmail.text = user.email.orEmpty()

        holder.itemView.setOnClickListener { onClick(user) }
    }

    override fun getItemCount(): Int = lista.size
}
