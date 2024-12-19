package com.example.spamear

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.spamear.databinding.ActivityRegistro4Binding
import com.google.firebase.firestore.FirebaseFirestore

class Registro4 : AppCompatActivity() {

    private lateinit var binding: ActivityRegistro4Binding
    private lateinit var mFirestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistro4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        mFirestore = FirebaseFirestore.getInstance()
        val userID = intent.getStringExtra("userID")

        binding.botonNextRegistro.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val contrasenia = binding.etPassword.text.toString().trim()
            val confirmarContrasenia = binding.etConfirmPassword.text.toString().trim()

            if (email.isEmpty() || contrasenia.isEmpty() || confirmarContrasenia.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            } else if (contrasenia != confirmarContrasenia) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            } else {

                mFirestore.collection("users").document(userID!!)
                    .update(
                        "email", email,
                        "contraseña", contrasenia
                    )
                    .addOnSuccessListener {
                        Toast.makeText(this, "Datos actualizados", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, Registro5::class.java)
                        intent.putExtra("userID", userID)
                        startActivity(intent)
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Error al actualizar", Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }
}