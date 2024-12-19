package com.example.spamear

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.spamear.databinding.ActivityRegistro1Binding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class registro1 : AppCompatActivity() {
    private lateinit var binding: ActivityRegistro1Binding
    private lateinit var auth: FirebaseAuth
    private lateinit var mFirestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistro1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        mFirestore = FirebaseFirestore.getInstance()

        binding.BotonSiguiente.setOnClickListener {
            val email = binding.IngresoCorreo.text.toString().trim()
            val password = binding.IngresoContrasenia.text.toString().trim()

            if (validateFields(email, password)) {
                registerUser(email, password)
            }
        }
    }

    private fun validateFields(email: String, password: String): Boolean {
        return when {
            email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                Toast.makeText(this, "Por favor, ingresa un correo válido.", Toast.LENGTH_SHORT).show()
                false
            }
            password.isEmpty() || password.length < 6 -> {
                Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres.", Toast.LENGTH_SHORT).show()
                false
            }
            else -> true
        }
    }

    private fun registerUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                val userID = auth.currentUser?.uid
                if (userID != null) {
                    guardarEnFirestore(userID, email, password)
                }
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error al registrar", Toast.LENGTH_SHORT).show()
            }
    }

    private fun guardarEnFirestore(userID: String, email: String, password: String) {
        val userData = hashMapOf(
            "email" to email,
            "contraseña" to password
        )

        mFirestore.collection("users").document(userID)
            .set(userData)
            .addOnSuccessListener {
                Toast.makeText(this, "Usuario registrado correctamente ", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, Registro11::class.java))
                finish()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, " ", Toast.LENGTH_SHORT).show()
            }
    }
}
