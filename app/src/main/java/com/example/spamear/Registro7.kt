package com.example.spamear

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.spamear.databinding.ActivityRegistro7Binding

class Registro7 : AppCompatActivity() {
    private lateinit var binding: ActivityRegistro7Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistro7Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val userID = intent.getStringExtra("userID")
        val zona = intent.getStringExtra("zona")
        val nombreMascota = intent.getStringExtra("nombre")
        val edadMascota = intent.getStringExtra("edad")

        binding.BotonSiguiente.setOnClickListener {
            val razaMascota = binding.IngresoRaza.text.toString().trim()

            if (razaMascota.isEmpty()) {
                Toast.makeText(this, "Ingresa la raza", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, Registro8::class.java)
                intent.putExtra("userID", userID)
                intent.putExtra("zona", zona)
                intent.putExtra("nombre", nombreMascota)
                intent.putExtra("edad", edadMascota)
                intent.putExtra("raza", razaMascota)
                startActivity(intent)
            }
        }
    }
}