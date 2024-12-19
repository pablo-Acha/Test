package com.example.spamear

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.spamear.databinding.ActivityRegistro8Binding

class Registro8 : AppCompatActivity() {

    private lateinit var binding: ActivityRegistro8Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistro8Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val userID = intent.getStringExtra("userID")
        val zona = intent.getStringExtra("zona")
        val nombreMascota = intent.getStringExtra("nombre")
        val edadMascota = intent.getStringExtra("edad")
        val razaMascota = intent.getStringExtra("raza")

        var tamanioMascota: String? = null

        // Configurar radio buttons
        binding.radioPequenio.setOnClickListener { tamanioMascota = "Pequeño" }
        binding.radioMediano.setOnClickListener { tamanioMascota = "Mediano" }
        binding.radioGrande.setOnClickListener { tamanioMascota = "Grande" }

        binding.BotonSiguiente.setOnClickListener {
            if (tamanioMascota.isNullOrEmpty()) {
                Toast.makeText(this, "Selecciona un tamaño", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, Registro10::class.java)
            intent.putExtra("userID", userID)
            intent.putExtra("zona", zona)
            intent.putExtra("nombre", nombreMascota)
            intent.putExtra("edad", edadMascota)
            intent.putExtra("raza", razaMascota)
            intent.putExtra("tamaño", tamanioMascota)
            startActivity(intent)
        }
    }
}
