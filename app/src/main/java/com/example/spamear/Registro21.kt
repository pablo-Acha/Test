package com.example.registro

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spamear.databinding.ActivityRegistro21Binding
import com.example.spamear.adapters.Recycler.ParejaAdapter
import com.example.spamear.dataclassPareja.Pareja
import com.google.firebase.firestore.FirebaseFirestore

class Registro21 : AppCompatActivity() {

    private lateinit var binding: ActivityRegistro21Binding
    private lateinit var adapter: ParejaAdapter
    private lateinit var firestore: FirebaseFirestore
    private val parejaList = mutableListOf<Pareja>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistro21Binding.inflate(layoutInflater)
        setContentView(binding.root)

        firestore = FirebaseFirestore.getInstance()

        setupRecyclerView()

        fetchPetsFromFirestore()
    }

    private fun setupRecyclerView() {
        adapter = ParejaAdapter()
        binding.parejas.layoutManager = LinearLayoutManager(this)
        binding.parejas.adapter = adapter
    }

    private fun fetchPetsFromFirestore() {
        firestore.collectionGroup("pets")
            .get()
            .addOnSuccessListener { documents ->
                parejaList.clear()
                for (document in documents) {
                    val pareja = document.toObject(Pareja::class.java)
                    parejaList.add(pareja)
                }
                adapter.updateData(parejaList)
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
