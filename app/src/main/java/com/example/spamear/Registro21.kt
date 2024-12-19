package com.example.spamear

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spamear.databinding.ActivityRegistro21Binding
import com.google.firebase.firestore.FirebaseFirestore

class Registro21 : AppCompatActivity() {

    private lateinit var binding: ActivityRegistro21Binding
    private lateinit var firestore: FirebaseFirestore
    private lateinit var adapter: MascotaAdapter
    private val mascotaList = mutableListOf<Mascota>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistro21Binding.inflate(layoutInflater)
        setContentView(binding.root)

        firestore = FirebaseFirestore.getInstance()

        setupDropdown()

        setupRecyclerView()

        fetchPetsFromFirestore()
    }

    private fun setupDropdown() {

        val razas = listOf("Labrador", "Golden Retriever", "Beagle", "Bulldog")

        val dropdownAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, razas)

        binding.menuItemRaza.setAdapter(dropdownAdapter)
    }

    private fun setupRecyclerView() {

        adapter = MascotaAdapter(mascotaList)

        binding.parejas.layoutManager = LinearLayoutManager(this)
        binding.parejas.adapter = adapter
    }

    private fun fetchPetsFromFirestore() {
        firestore.collectionGroup("pets")
            .get()
            .addOnSuccessListener { documents ->
                mascotaList.clear()
                for (document in documents) {
                    val mascota = document.toObject(Mascota::class.java)
                    mascotaList.add(mascota)
                }
                adapter.notifyDataSetChanged()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error al cargar datos: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
