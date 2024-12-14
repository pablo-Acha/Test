package com.example.spamear

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.spamear.databinding.ActivityConfiguracionDePerfilBinding
import com.example.spamear.databinding.ActivityRegistro3Binding

class ConfiguracionDePerfil : AppCompatActivity() {
    private lateinit var binding: ActivityConfiguracionDePerfilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfiguracionDePerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}