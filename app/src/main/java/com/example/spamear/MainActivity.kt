package com.example.spamear

import com.example.spamear.Registro2
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import com.example.spamear.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.BotonRegistro3.setOnClickListener {
            val intentScroll = Intent(this, Registro3::class.java)
            startActivity(intentScroll)
        }

        binding.BotonRegistro1.setOnClickListener {
            val intentScroll = Intent(this, registro1::class.java)
            startActivity(intentScroll)
        }

        binding.bottonRegistro5.setOnClickListener {
            val intentScroll = Intent(this, Registro5::class.java)
            startActivity(intentScroll)
        }

        binding.bottonRegistro6.setOnClickListener {
            val intentScroll = Intent(this, Registro6::class.java)
            startActivity(intentScroll)
        }
        binding.bottonConfiguracion.setOnClickListener {
            val intentScroll = Intent(this, ConfiguracionDePerfil::class.java)
            startActivity(intentScroll)
        }
        binding.BotonRegistro11.setOnClickListener {
            val intentScroll = Intent(this, Registro11::class.java)
            startActivity(intentScroll)
        }
        binding.BotonRegistro2.setOnClickListener {
            val intentScroll = Intent(this, Registro2::class.java)
            startActivity(intentScroll)
        }
        binding.BotonRegistro7.setOnClickListener {
            val intentScroll = Intent(this, Registro7::class.java)
            startActivity(intentScroll)
        }
        binding.BotonRegistro8.setOnClickListener {
            val intentScroll = Intent(this, Registro8::class.java)
            startActivity(intentScroll)
        }

        binding.BotonAnuncio.setOnClickListener {
            val intentScroll = Intent(this, PantallaAnuncios::class.java)
            startActivity(intentScroll)
        }
        binding.botonPublicar.setOnClickListener {
            val intentScroll = Intent(this, PublicarAdopcion::class.java)
            startActivity(intentScroll)
        }
        binding.parejas.setOnClickListener {
            val intentScroll = Intent(this, Registro21::class.java)
            startActivity(intentScroll)
        }
    }
}