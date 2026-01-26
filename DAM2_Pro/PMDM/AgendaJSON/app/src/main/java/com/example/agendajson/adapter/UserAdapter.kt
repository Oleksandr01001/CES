package com.example.agendajson.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agendajson.R
import com.example.agendajson.databinding.ItemUserCardBinding
import com.example.agendajson.model.User

class UserAdapter(var context: Context) : RecyclerView.Adapter<UserAdapter.MyHolder>() {

    private var lista: ArrayList<User> = ArrayList()
    private val listener: OnItemUserListener = context as OnItemUserListener

    inner class MyHolder(var binding: ItemUserCardBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.toolbarCard.menu.clear()
            binding.toolbarCard.inflateMenu(R.menu.user_menu)

            binding.toolbarCard.setOnMenuItemClickListener { item ->
                val user = lista[bindingAdapterPosition]
                when (item.itemId) {
                    R.id.menu_user_detalle -> listener.onUserDetailSelected(user)
                    R.id.menu_user_fav -> listener.onUserAddFavSelected(user)
                    R.id.menu_user_e_fav -> listener.onUserRemoveFavSelected(user)
                }
                true
            }
        }
    }

    fun clearUsers() {
        lista.clear()
        notifyDataSetChanged()
    }

    fun addUSer(user: User) {
        lista.add(user)
        notifyItemInserted(lista.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = ItemUserCardBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val user = lista[position]
        holder.binding.textoCard.text = user.email
        holder.binding.toolbarCard.title = user.firstName
        Glide.with(context).load(user.image).into(holder.binding.imagenCard)
    }

    override fun getItemCount(): Int = lista.size

    interface OnItemUserListener {
        fun onUserDetailSelected(user: User)
        fun onUserAddFavSelected(user: User)
        fun onUserRemoveFavSelected(user: User)
    }
}
