package com.example.spacexlaunches.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examenfinal.databinding.ItemLaunchBinding
import com.example.spacexlaunches.model.Launch

class LaunchAdapter(
    private var list: List<Launch>,
    private val onFav: (Launch) -> Unit
) : RecyclerView.Adapter<LaunchAdapter.VH>() {

    fun update(newList: List<Launch>) {
        list = newList
        notifyDataSetChanged()
    }

    inner class VH(val b: ItemLaunchBinding) : RecyclerView.ViewHolder(b.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val b = ItemLaunchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(b)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val l = list[position]
        holder.b.tvName.text = l.name ?: ""
        holder.b.tvDetail.text = l.details ?: "Sin detalle"

        val url = l.links?.patch?.small
        Glide.with(holder.itemView.context)
            .load(url)
            .into(holder.b.imgPatch)

        holder.b.btnFav.setOnClickListener { onFav(l) }
    }

    override fun getItemCount() = list.size
}
