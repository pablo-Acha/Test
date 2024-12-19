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
import com.example.spamear.databinding.ActivityPublicarAdopcionBinding
import com.example.spamear.databinding.ActivityRegistro6Binding
import com.example.spamear.dataclass.PerfilAnuncio
import com.example.spamear.dataclass.Zonas
import com.google.gson.Gson


class PublicarAdopcion : AppCompatActivity() {

    private lateinit var binding: ActivityPublicarAdopcionBinding
    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    companion object {
        const val SHARED_PREFS_NAME = "perfil_prefs"
        const val CLAVES_KEY = "claves"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPublicarAdopcionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        drawerLayout = binding.drawerMain
        actionBarDrawerToggle = ActionBarDrawerToggle(
            this, drawerLayout, binding.toolbarMain, R.string.nav_open, R.string.nav_close
        )

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

        binding.botonPublicar.setOnClickListener {
            // Crear el objeto PerfilAnuncio con los valores del formulario
            val perfilAnuncio = PerfilAnuncio(
                titulo = binding.editTextAdopP.text.toString(),
                nombre = binding.editTextNombre.text.toString(),
                imagen = "", // Campo de imagen vacío
                descripcion = "\uD83D\uDC3E Nombre: ${binding.editTextNombre.text}\n \uD83D\uDC3E Edad: ${binding.editTextEdad.text}\n,\uD83C\uDFF7\uFE0F Raza: ${binding.editTextRaza.text}\n, " +
                        "\uD83D\uDC15 Tamaño: ${binding.editTextTamanio.text}\n,\uD83D\uDC89 Vacuna: ${binding.editTextVacuna.text}\n, " +
                        "✂\uFE0F Esterilización: ${binding.editTextEsterilizacion.text}\n"

            )

            // Limpiar los campos de texto
            binding.editTextNombre.text.clear()
            binding.editTextEdad.text.clear()
            binding.editTextRaza.text.clear()
            binding.editTextTamanio.text.clear()
            binding.editTextVacuna.text.clear()
            binding.editTextEsterilizacion.text.clear()

            // Aquí puedes usar el objeto perfilAnuncio, por ejemplo, enviarlo a un servidor o guardarlo localmente
            guardarPerfilEnSharedPreferences(perfilAnuncio)
        }
    }

    private fun guardarPerfilEnSharedPreferences(perfilAnuncio: PerfilAnuncio) {

        val sharedPref = getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        val gson = Gson()

        // Recuperar la lista de claves existentes
        val clavesJson = sharedPref.getString(CLAVES_KEY, "[]")
        val claves = gson.fromJson(clavesJson, ArrayList::class.java) as ArrayList<String>

        // Generar una nueva clave única
        val nuevaClave = "perfil_${claves.size + 1}"
        claves.add(nuevaClave)

        // Guardar la nueva lista de claves
        editor.putString(CLAVES_KEY, gson.toJson(claves))

        // Guardar el objeto PerfilAnuncio con la nueva clave
        val perfilJson = gson.toJson(perfilAnuncio)
        editor.putString(nuevaClave, perfilJson)

        // Aplicar los cambios
        editor.apply()
    }




}