package com.example.myapplicationproducto

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationproducto.data.adapter.AdapterProducto

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recircleyView = findViewById<RecyclerView>(R.id.listProducto)
        // 1. Preparar los datos
        val names = listOf(
            "Alice", "Bob", "Charlie", "David", "Eve", "Frank",
            "Grace", "Heidi", "Ivan", "Judy", "Kim", "Liam",
            "Mia", "Noah", "Olivia", "Peter", "Quinn", "Rachel",
            "Sam", "Tina", "Uma", "Victor", "Wendy", "Xavier",
            "Yara", "Zack", "Anna", "Ben", "Catherine", "Daniel",
            "Ella", "Felix", "Georgia", "Harry", "Isabel", "Jack"
        )

            // 2. Inicializar el RecyclerView
            //    Configurar el LayoutManager (en este caso, un LinearLayoutManager para una lista vertical)
        recircleyView.layoutManager = LinearLayoutManager(this)

        // 3. Crear una instancia de nuestro adaptador
        val adapter = AdapterProducto(names)

        // 4. Asignar el adaptador al RecyclerView
        recircleyView.adapter = adapter
    }
}