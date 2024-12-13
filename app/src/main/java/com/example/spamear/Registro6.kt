package com.example.spamear

import android.os.Bundle
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
        val view = binding.root
        setContentView(view)
    }
}