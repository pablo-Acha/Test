package com.example.spamear.adapters.Recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.spamear.databinding.ItemZonasBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.spamear.dataclass.Zonas


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.EjemploViewHolder>() {

    private val listaDatos = mutableListOf<Zonas>()
    private var context: Context? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EjemploViewHolder {
        context = parent.context
        return EjemploViewHolder(
            ItemZonasBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EjemploViewHolder, position: Int) {
        holder.binding(listaDatos[position])
    }

    override fun getItemCount(): Int = listaDatos.size

    inner class EjemploViewHolder(private val binding: ItemZonasBinding) :
        RecyclerView.ViewHolder(binding.root)  {
        fun binding(data: Zonas) {
            binding.checkBox1.id = data.id
            binding.checkBox1.isChecked = data.checkeo
            binding.textViewZona.text = data.nombreZona
            binding.textViewZonas.text = data.zonas
            binding.checkBox1.setOnCheckedChangeListener { _, isChecked ->
                // Actualiza el valor en la lista de datos
                data.checkeo = isChecked
            }
        }
    }

    fun addDataToList(list: MutableList<Zonas>) {
        listaDatos.clear()

        listaDatos.addAll(list)
    }

}