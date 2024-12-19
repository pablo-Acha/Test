package com.example.spamear

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.spamear.databinding.ActivityRegistro11Binding
import com.google.firebase.auth.FirebaseAuth

class Registro11 : AppCompatActivity() {

    private lateinit var binding: ActivityRegistro11Binding
    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistro11Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarMain)

        // Configurar DrawerLayout y ActionBarDrawerToggle
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
                }
                R.id.nav_logout -> {
                    FirebaseAuth.getInstance().signOut()
                    Toast.makeText(this, "Sesión cerrada.", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
            true
        }







        /*binding.botonCasa.setOnClickListener {

            val intent = Intent(this, Registro11::class.java)
            startActivity(intent)
        }*/
    }




    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }






}