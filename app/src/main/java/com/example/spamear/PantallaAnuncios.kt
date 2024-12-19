package com.example.spamear

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spamear.adapters.Recycler.RecyclerAdapter
import com.example.spamear.adapters.Recycler.RecyclerAdapterAnuncios
import com.example.spamear.databinding.ActivityPantallaAnunciosBinding
import com.example.spamear.databinding.ActivityRegistro8Binding
import com.example.spamear.dataclass.PerfilAnuncio
import com.example.spamear.dataclass.Zonas
import com.example.spamear.PublicarAdopcion.Companion.CLAVES_KEY
import com.example.spamear.PublicarAdopcion.Companion.SHARED_PREFS_NAME
import com.google.gson.Gson

class PantallaAnuncios : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaAnunciosBinding
    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private val recylcerEjemploAdapter by lazy { RecyclerAdapterAnuncios() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaAnunciosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()

        drawerLayout = binding.drawerMain
        actionBarDrawerToggle = ActionBarDrawerToggle(
            this, drawerLayout, binding.toolbarMain, R.string.nav_open, R.string.nav_close
        )

        binding.botonBorrar.setOnClickListener {
            val sharedPref = getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
            sharedPref.edit().clear().apply()

        }

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        actionBarDrawerToggle.syncState()

        binding.navigationMenu.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navCuenta -> {

                    val intent = Intent(this, ConfiguracionDePerfil::class.java)
                    startActivity(intent)
                    true
                }else -> false
            }
        }
        binding.botonCasa.setOnClickListener {
            val intent = Intent(this, Registro11::class.java)
            startActivity(intent)
        }

    }

    fun setUpRecyclerView(){
        val listaDatos: MutableList<PerfilAnuncio> = mutableListOf()
        val l = mutableListOf(
            PerfilAnuncio(
                titulo = "Adopcion",
                nombre = "max",
                imagen = "",
                descripcion = "\uD83D\uDC3E Nombre: Max\n" +
                        "\uD83D\uDCC5 Edad: 2 años\n" +
                        "\uD83C\uDFF7\uFE0F Raza: Labrador mestizo\n" +
                        "\uD83D\uDC15 Tamaño: Mediano (25 kg)\n" +
                        "\uD83D\uDC89 Vacunas: Al día\n" +
                        "✂\uFE0F Esterilizado: Sí"
            ), PerfilAnuncio(
                titulo = "Perdido",
                nombre = "Luna",
                imagen = "",
                descripcion = "\uD83D\uDC3E Nombre: Luna\n" +
                        "\uD83D\uDCC5 Edad: 3 años\n" +
                        "\uD83C\uDFF7\uFE0F Raza: Pastor alemán\n" +
                        "\uD83D\uDC15 Tamaño: Grande (30 kg)\n" +
                        "\uD83D\uDC89 Vacunas: Al día\n" +
                        "✂\uFE0F Esterilizado: Sí"
            ),
            PerfilAnuncio(
                titulo = "Adopcion",
                nombre = "Rocky",
                imagen = "",
                descripcion = "\uD83D\uDC3E Nombre: Rocky\n" +
                        "\uD83D\uDCC5 Edad: 1 año\n" +
                        "\uD83C\uDFF7\uFE0F Raza: Beagle\n" +
                        "\uD83D\uDC15 Tamaño: Pequeño (10 kg)\n" +
                        "\uD83D\uDC89 Vacunas: Al día\n" +
                        "✂\uFE0F Esterilizado: No"
            ),
            PerfilAnuncio(
                titulo = "Perdido",
                nombre = "Bella",
                imagen = "",
                descripcion = "\uD83D\uDC3E Nombre: Bella\n" +
                        "\uD83D\uDCC5 Edad: 5 años\n" +
                        "\uD83C\uDFF7\uFE0F Raza: Golden retriever\n" +
                        "\uD83D\uDC15 Tamaño: Grande (35 kg)\n" +
                        "\uD83D\uDC89 Vacunas: Al día\n" +
                        "✂\uFE0F Esterilizado: Sí"
            ),
            PerfilAnuncio(
                titulo = "Adopcion",
                nombre = "Coco",
                imagen = "",
                descripcion = "\uD83D\uDC3E Nombre: Coco\n" +
                        "\uD83D\uDCC5 Edad: 4 años\n" +
                        "\uD83C\uDFF7\uFE0F Raza: Chihuahua\n" +
                        "\uD83D\uDC15 Tamaño: Pequeño (4 kg)\n" +
                        "\uD83D\uDC89 Vacunas: Al día\n" +
                        "✂\uFE0F Esterilizado: Sí"
            ),
            PerfilAnuncio(
                titulo = "Perdido",
                nombre = "Shadow",
                imagen = "",
                descripcion = "\uD83D\uDC3E Nombre: Shadow\n" +
                        "\uD83D\uDCC5 Edad: 3 años\n" +
                        "\uD83C\uDFF7\uFE0F Raza: Husky siberiano\n" +
                        "\uD83D\uDC15 Tamaño: Grande (28 kg)\n" +
                        "\uD83D\uDC89 Vacunas: Al día\n" +
                        "✂\uFE0F Esterilizado: No"
            ),
            PerfilAnuncio(
                titulo = "Adopcion",
                nombre = "Nala",
                imagen = "",
                descripcion = "\uD83D\uDC3E Nombre: Nala\n" +
                        "\uD83D\uDCC5 Edad: 2 años\n" +
                        "\uD83C\uDFF7\uFE0F Raza: Border Collie\n" +
                        "\uD83D\uDC15 Tamaño: Mediano (18 kg)\n" +
                        "\uD83D\uDC89 Vacunas: Al día\n" +
                        "✂\uFE0F Esterilizado: Sí"
            ),
            PerfilAnuncio(
                titulo = "Perdido",
                nombre = "Lucky",
                imagen = "",
                descripcion = "\uD83D\uDC3E Nombre: Lucky\n" +
                        "\uD83D\uDCC5 Edad: 1 año\n" +
                        "\uD83C\uDFF7\uFE0F Raza: Cocker Spaniel\n" +
                        "\uD83D\uDC15 Tamaño: Mediano (12 kg)\n" +
                        "\uD83D\uDC89 Vacunas: Al día\n" +
                        "✂\uFE0F Esterilizado: No"
            )
        )
        val listaShared  = encontrarAnuncios()
        if(listaShared.size != 0){
            for (i in listaShared.size-1 downTo 0) {
                listaDatos.add(listaShared[i])
            }
        }
        for (perfilAnuncio in l) {
            listaDatos.add(perfilAnuncio)
        }
        recylcerEjemploAdapter.addDataToList(listaDatos)

        binding.recyclerViewAnuncio.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = recylcerEjemploAdapter

        }

    }

    fun encontrarAnuncios(): MutableList<PerfilAnuncio> {
        val sharedPref = getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
        val gson = Gson()
        val listaAnuncios = mutableListOf<PerfilAnuncio>()

        val clavesJson = sharedPref.getString(CLAVES_KEY, "[]")
        val claves = gson.fromJson(clavesJson, ArrayList::class.java) as ArrayList<String>

        for (clave in claves) {
            val perfilJson = sharedPref.getString(clave, null)
            if (perfilJson != null) {
                val perfilAnuncio = gson.fromJson(perfilJson, PerfilAnuncio::class.java)
                listaAnuncios.add(perfilAnuncio)
            }
        }

        return listaAnuncios
    }

}