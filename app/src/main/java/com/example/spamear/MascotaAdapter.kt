package com.example.spamear

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spamear.databinding.PetItemBinding

class MascotaAdapter(private val mascotaList: List<Mascota>) :
    RecyclerView.Adapter<MascotaAdapter.ViewHolder>() {

    // ViewHolder ahora utiliza el binding directamente
    class ViewHolder(private val binding: PetItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(mascota: Mascota) {
            binding.petName.text = "Nombre: ${mascota.nombre}"
            binding.petAge.text = "Edad: ${mascota.edad}"
            binding.petBreed.text = "Raza: ${mascota.raza}"
            binding.petZone.text = "Zona: ${mascota.zona}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PetItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mascota = mascotaList[position]
        holder.bind(mascota) // Llama a la función bind para asignar los datos
    }

    override fun getItemCount(): Int = mascotaList.size
}
