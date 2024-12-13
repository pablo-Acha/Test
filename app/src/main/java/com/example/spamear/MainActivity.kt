package com.example.spamear

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.spamear.databinding.ActivityMainBinding
import com.example.spamear.databinding.ActivityRegistro3Binding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BotonRegistro3.setOnClickListener {
            val intentScroll = Intent(this, Registro3::class.java)
            startActivity(intentScroll)
        }

        binding.BotonRegistro1.setOnClickListener {
            val intentScroll = Intent(this, registro1::class.java)
            startActivity(intentScroll)
        }

    }
}