package com.example.spamear

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class Registro2 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro2)

        auth = FirebaseAuth.getInstance()

        if (auth.currentUser != null) {
            startActivity(Intent(this, Registro11::class.java))
            finish()
        }

        val emailField = findViewById<EditText>(R.id.IngresoCorreo)
        val passwordField = findViewById<EditText>(R.id.IngresoContrasenia)
        val loginButton = findViewById<Button>(R.id.BtnSiguiente)
        val signUpButton = findViewById<Button>(R.id.BtnSingUp)

        loginButton.setOnClickListener {
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()

            if (validateFields(email, password)) {
                loginUser(email, password)
            }
        }
        signUpButton.setOnClickListener {
            startActivity(Intent(this, registro1::class.java))
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
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

}