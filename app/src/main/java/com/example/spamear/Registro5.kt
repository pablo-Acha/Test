package com.example.spamear

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spamear.adapters.Recycler.RecyclerAdapter
import com.example.spamear.databinding.ActivityRegistro5Binding
import com.example.spamear.dataclass.Zonas

class Registro5 : AppCompatActivity() {

    private lateinit var binding: ActivityRegistro5Binding

    private val recylcerEjemploAdapter by lazy { RecyclerAdapter() }

    var listaDatos : MutableList<Zonas>  = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistro5Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUpRecyclerView()

    }

    fun setUpRecyclerView(){
        listaDatos = mutableListOf(
            Zonas(
                id = 1,
                checkeo = false,
                nombreZona = "Zona Sur",
                zonas = "jijiji"
            ),Zonas(
                id = 2,
                checkeo = false,
                nombreZona = "Zona Norte",
                zonas = "jijiji"
            ),Zonas(
                id = 3,
                checkeo = false,
                nombreZona = "Centro",
                zonas = "jijiji"
            ),Zonas(
                id = 4,
                checkeo = false,
                nombreZona = "Zona Este",
                zonas = "jijiji"
            ),Zonas(
                id = 5,
                checkeo = false,
                nombreZona = "Zona Oeste",
                zonas = "jijiji"
            ),Zonas(
                id = 6,
                checkeo = false,
                nombreZona = "El Alto",
                zonas = "jijiji"
            ),Zonas(
                id = 7,
                checkeo = false,
                nombreZona = "Zona Periferica",
                zonas = "jijiji"
            ),
        )
        recylcerEjemploAdapter.addDataToList(listaDatos)

        binding.recyclerEjemplo.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = recylcerEjemploAdapter

        }


    }

    fun validar(){
        val seleccionados = listaDatos.filter { it.checkeo }
        if (seleccionados.isNotEmpty()) {
            seleccionados.forEach {
                println("Zona seleccionada: ${it.nombreZona}")
            }
        } else {
            println("No hay zonas seleccionadas.")
        }
    }




}