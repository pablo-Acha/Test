package com.example.spamear

import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.example.spamear.databinding.ActivityRegistro8Binding

class Registro8 : AppCompatActivity() {

    private lateinit var binding: ActivityRegistro8Binding
    private var lastSelectedRadioButton: RadioButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistro8Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configura el comportamiento de los RadioButtons
        setupRadioButtonBehavior()
    }

    private fun setupRadioButtonBehavior() {
        // Configurar los RadioButtons para que solo uno pueda seleccionarse a la vez
        binding.radioPequenio.setOnClickListener { handleRadioButtonSelection(binding.radioPequenio) }
        binding.radioMediano.setOnClickListener { handleRadioButtonSelection(binding.radioMediano) }
        binding.radioGrande.setOnClickListener { handleRadioButtonSelection(binding.radioGrande) }
    }

    private fun handleRadioButtonSelection(currentRadioButton: RadioButton) {
        // Deseleccionar el último RadioButton seleccionado
        lastSelectedRadioButton?.isChecked = false

        // Seleccionar el actual RadioButton
        currentRadioButton.isChecked = true

        // Actualizar el último RadioButton seleccionado
        lastSelectedRadioButton = currentRadioButton
    }
}
