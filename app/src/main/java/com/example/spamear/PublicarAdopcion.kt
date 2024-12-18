package com.example.spamear

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
import com.example.spamear.dataclass.Zonas

class PublicarAdopcion : AppCompatActivity() {

    private lateinit var binding: ActivityPublicarAdopcionBinding
    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

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





    }
}