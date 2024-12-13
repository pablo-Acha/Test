package com.example.spamear

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.spamear.databinding.ActivityRegistro3Binding

class Registro3 : AppCompatActivity() {

    private lateinit var binding: ActivityRegistro3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistro3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            val name = binding.etName.text.toString()
            val age = binding.etAge.text.toString()

            if (name.isEmpty() || age.isEmpty()) {
                Toast.makeText(this, "Debes completar todos los campos", Toast.LENGTH_SHORT).show()
            }
            //    else {
//                val intent = Intent(this, RegisterActivity::class.java)
//                startActivity(intent)
//            }
        }
    }
}