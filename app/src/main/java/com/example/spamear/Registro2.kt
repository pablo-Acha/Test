package com.example.spamear

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.spamear.databinding.ActivityRegistro2Binding
import com.google.firebase.auth.FirebaseAuth

class Registro2 : AppCompatActivity() {

    private lateinit var binding: ActivityRegistro2Binding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistro2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.BtnSiguiente.setOnClickListener {
            val email = binding.IngresoCorreo.text.toString().trim()
            val password = binding.IngresoContrasenia.text.toString().trim()

            if (validateFields(email, password)) {
                loginUser(email, password)
            }
        }
        binding.BtnSingUp.setOnClickListener {
            startActivity(Intent(this, Registro4::class.java))
        }
    }

    private fun validateFields(email: String, password: String): Boolean {
        return when {
            email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
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

    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                Toast.makeText(this, "Inicio de sesión exitoso.", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, Registro11::class.java))
                finish()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "No tiene cuenta. Por favor, regístrese.", Toast.LENGTH_SHORT).show()
            }
    }
}
