package com.example.spamear

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.spamear.databinding.ActivityRegistro3Binding
import com.google.firebase.firestore.FirebaseFirestore

class Registro3 : AppCompatActivity() {

    private lateinit var binding: ActivityRegistro3Binding
    private lateinit var mFirestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistro3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        mFirestore = FirebaseFirestore.getInstance()

        binding.botonNextDuenio.setOnClickListener {
            val nombre = binding.nombreDuenio.text.toString().trim()
            val edad = binding.edadDuenio.text.toString().trim()

            if (nombre.isEmpty() || edad.isEmpty()) {
                Toast.makeText(this, "Debes completar todos los campos", Toast.LENGTH_SHORT).show()
            } else {

                val userMap = hashMapOf(
                    "nombre" to nombre,
                    "edad" to edad
                )

                mFirestore.collection("users").add(userMap).addOnSuccessListener {
                    documentRef ->

                    val userID = documentRef.id
                    Toast.makeText(this, "El usuario se guardó con exito", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, Registro4::class.java)
                    intent.putExtra("userID", userID)
                    startActivity(intent)
                }.addOnFailureListener{
                    Toast.makeText(this, "Error, no pudo guardarse", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}