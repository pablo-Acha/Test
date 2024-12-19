package com.example.spamear.adapters.Recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spamear.databinding.ItemParejaBinding
import com.example.spamear.dataclassPareja.Pareja

class ParejaAdapter : RecyclerView.Adapter<ParejaAdapter.ViewHolder>() {

    private val parejaList = mutableListOf<Pareja>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemParejaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(parejaList[position])
    }

    override fun getItemCount(): Int = parejaList.size

    fun updateData(newList: MutableList<Pareja>) {
        parejaList.clear()
        parejaList.addAll(newList)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemParejaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pareja: Pareja) {
            binding.nombreMascota.text = "Nombre: ${pareja.nombre}"
            binding.razaMascota.text = "Raza: ${pareja.raza}"
            binding.edadMascota.text = "Edad: ${pareja.edad}"
            binding.zonaMascota.text = "Zona: ${pareja.zona}"
        }
    }
}
