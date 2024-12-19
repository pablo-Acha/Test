package com.example.spamear

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.spamear.databinding.ActivityRegistro1Binding
import com.google.firebase.auth.FirebaseAuth

class registro1 : AppCompatActivity() {
    private lateinit var binding: ActivityRegistro1Binding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistro1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.BotonSiguiente.setOnClickListener {
            val email = binding.IngresoCorreo.text.toString().trim()
            val password = binding.IngresoContrasenia.text.toString().trim()

            if (validateFields(email, password)) {
                registerUser(email, password)
            }
        }
        binding.BotonSiguiente.setOnClickListener {
            val intentScroll = Intent(this, Registro2::class.java)
            startActivity(intentScroll)
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
                Toast.makeText(this, "Usuario registrado correctamente.", Toast.LENGTH_SHORT).show()
                // Redirige al flujo siguiente
                startActivity(Intent(this, Registro2::class.java))
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error al registrar: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}