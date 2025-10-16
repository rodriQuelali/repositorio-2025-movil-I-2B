package com.example.calculadorapoo.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calculadorapoo.R
import com.example.calculadorapoo.data.Pais
import com.example.calculadorapoo.data.adapter.AdapterName
import com.example.calculadorapoo.databinding.ActivityMainBinding

class RecircleyViewHome : AppCompatActivity() {

    //no permite iteractuar con el xml directo sin la clase R.
    //private lateinit var binding: ActivityMainBinding

    lateinit var rViewRecircley: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recircley_view_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // 1. Preparar los datos
        val names: List<Pais> = listOf(Pais("Bolivia", 12455555), Pais("Peru", 2555555))
        rViewRecircley = findViewById(R.id.rViewRecircley)
        rViewRecircley.layoutManager = LinearLayoutManager(this)
        // 3. Crear una instancia de nuestro adaptador
        val adapter = AdapterName(names)
        // 4. Asignar el adaptador al RecyclerView
        rViewRecircley.adapter = adapter
    }

}