package com.example.proyectosqli

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectosqli.ui.producto.Articulo
import com.google.android.material.button.MaterialButton

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnUsuarios = findViewById<MaterialButton>(R.id.btnUsuarios)
        val btnArticulos = findViewById<MaterialButton>(R.id.btnArticulos)

        btnUsuarios.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            Toast.makeText(this, "Ir a Gestión de Usuarios", Toast.LENGTH_SHORT).show()
        }

        btnArticulos.setOnClickListener {
            startActivity(Intent(this, Articulo::class.java))
            Toast.makeText(this, "Ir a Gestión de Artículos", Toast.LENGTH_SHORT).show()
        }
    }
}