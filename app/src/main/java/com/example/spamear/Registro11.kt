package com.example.spamear

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.spamear.databinding.ActivityRegistro11Binding

class Registro11 : AppCompatActivity() {

    private lateinit var binding: ActivityRegistro11Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistro11Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.menu.setOnClickListener {

            val intent = Intent(this, ConfiguracionDePerfil::class.java)
            startActivity(intent)
        }
        binding.botonCasa.setOnClickListener {

            val intent = Intent(this, Registro11::class.java)
            startActivity(intent)
        }
    }
}