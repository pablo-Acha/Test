package com.example.spamear

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.spamear.databinding.ActivityRegistro10Binding
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore

class Registro10 : AppCompatActivity() {

    private lateinit var binding: ActivityRegistro10Binding
    private lateinit var firestore: FirebaseFirestore

    private var lastSelectedRadioButton: RadioButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistro10Binding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseApp.initializeApp(this)
        firestore = FirebaseFirestore.getInstance()

        val userID = intent.getStringExtra("userID")
        val zona = intent.getStringExtra("zona")
        val nombreMascota = intent.getStringExtra("nombre")
        val edadMascota = intent.getStringExtra("edad")
        val razaMascota = intent.getStringExtra("raza")
        val tamanioMascota = intent.getStringExtra("tamaño")

        binding.BotonSiguiente.setOnClickListener {
            val generoMascota = when {
                binding.radioMediano.isChecked -> "Macho"
                binding.radioGrande.isChecked -> "Hembra"
                else -> ""
            }

            if (generoMascota.isEmpty()) {
                Toast.makeText(this, "Selecciona el género", Toast.LENGTH_SHORT).show()
            } else {

                val petData = hashMapOf(
                    "nombre" to nombreMascota,
                    "edad" to edadMascota,
                    "raza" to razaMascota,
                    "tamaño" to tamanioMascota,
                    "género" to generoMascota,
                    "zona" to zona,
                    "userID" to userID
                )
                Log.d("PetDataDebug", petData.toString())
                Toast.makeText(this, "sisi", Toast.LENGTH_SHORT).show()
                firestore.collection("users")
                    .document(userID!!)
                    .collection("pets")
                    .add(petData)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Mascota registrada con éxito", Toast.LENGTH_SHORT)
                            .show()
                        finish()
                        val intentScroll = Intent(this, Registro11::class.java)
                        startActivity(intentScroll)

                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                    }

            }
        }
    }
}
