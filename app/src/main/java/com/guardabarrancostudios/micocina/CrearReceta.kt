package com.guardabarrancostudios.micocina

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.guardabarrancostudios.micocina.databinding.ActivityCrearRecetaBinding

class CrearReceta : AppCompatActivity() {
    private lateinit var binding: ActivityCrearRecetaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCrearRecetaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        binding.btnPostear.setOnClickListener{
            Toast.makeText(this, "Este boton Postear funciona", Toast.LENGTH_SHORT).show()
        }

        binding.btnSeleccionarImagen.setOnClickListener{
            Toast.makeText(this, "Este boton Imagen funciona", Toast.LENGTH_SHORT).show()
        }

        binding.btnPerfil.setOnClickListener{
            val paginaPerfil = Intent(this, Perfil::class.java)
            startActivity(paginaPerfil)
        }

        binding.btnInicio.setOnClickListener{
            val paginaInicio = Intent(this, Inicio::class.java)
            startActivity(paginaInicio)
        }

    }
}