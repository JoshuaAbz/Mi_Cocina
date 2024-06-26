package com.guardabarrancostudios.micocina

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.guardabarrancostudios.micocina.databinding.ActivityBuscarBinding

class Buscar : AppCompatActivity() {
    private lateinit var binding: ActivityBuscarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBuscarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnAtras.setOnClickListener{
            val paginaInicio = Intent(this, Inicio::class.java)
            startActivity(paginaInicio)
        }

    }
}