package com.guardabarrancostudios.micocina

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.guardabarrancostudios.micocina.databinding.ActivityPrincipalBinding

class Principal : AppCompatActivity() {

    private lateinit var binding: ActivityPrincipalBinding

    private var idItemActual: Int = R.id.nav_inicio

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configurar el BottomNavigationView
        binding.navegacion.setOnNavigationItemSelectedListener { menuItem ->
            if (menuItem.itemId != idItemActual) {
                when (menuItem.itemId) {
                    R.id.nav_crear -> {
                        idItemActual = R.id.nav_crear
                        loadLayout(R.layout.activity_crear_receta)
                        true
                    }
                    R.id.nav_inicio -> {
                        idItemActual = R.id.nav_inicio
                        loadLayout(R.layout.activity_inicio)
                        true
                    }
                    R.id.nav_perfil -> {
                        idItemActual = R.id.nav_perfil
                        loadLayout(R.layout.activity_perfil)
                        true
                    }
                    else -> false
                }
            } else {
                true
            }
        }

        // Cargar el layout de inicio por defecto
        loadLayout(R.layout.activity_inicio)
    }

    private fun loadLayout(layoutResId: Int) {
        // Inflar el layout y agregarlo al FrameLayout
        val inflater = layoutInflater
        val view = inflater.inflate(layoutResId, binding.contenedor, false)
        binding.contenedor.removeAllViews()
        binding.contenedor.addView(view)
    }
}
