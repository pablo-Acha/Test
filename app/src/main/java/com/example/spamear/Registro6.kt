package com.example.spamear

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.spamear.databinding.ActivityRegistro5Binding
import com.example.spamear.databinding.ActivityRegistro6Binding

class Registro6 : AppCompatActivity() {
    private lateinit var binding: ActivityRegistro6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistro6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val userID = intent.getStringExtra("userID")
        val zona = intent.getStringExtra("zona")

        binding.BotonSiguiente.setOnClickListener {
            val nombreMascota = binding.CV1Cn1textView.text.toString().trim()
            val edadMascota = binding.CV1Cn2textView.text.toString().trim()

            if (nombreMascota.isEmpty() || edadMascota.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, Registro7::class.java)
                intent.putExtra("userID", userID)
                intent.putExtra("zona", zona)
                intent.putExtra("nombre", nombreMascota)
                intent.putExtra("edad", edadMascota)
                startActivity(intent)
            }
        }
    }
}