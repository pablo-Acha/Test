package com.example.spamear.adapters.Recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spamear.databinding.ItemAnuncioBinding
import com.example.spamear.dataclass.PerfilAnuncio

class RecyclerAdapterAnuncios: RecyclerView.Adapter<RecyclerAdapterAnuncios.EjemploViewHolder>() {

    private val listaDatos = mutableListOf<PerfilAnuncio>()
    private var context: Context? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EjemploViewHolder {
        context = parent.context
        return EjemploViewHolder(
            ItemAnuncioBinding.inflate(
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

    inner class EjemploViewHolder(private val binding: ItemAnuncioBinding) :
        RecyclerView.ViewHolder(binding.root)  {
        fun binding(data: PerfilAnuncio) {
            binding.tituloItemAnuncio.text = data.titulo
            binding.descripcionPerro.text = data.descripcion
            binding.nombrePerro.text = data.nombre
            TODO("agregar imagen")
        }
    }

    fun addDataToList(list: MutableList<PerfilAnuncio>) {
        listaDatos.clear()
        listaDatos.addAll(list)
    }
}