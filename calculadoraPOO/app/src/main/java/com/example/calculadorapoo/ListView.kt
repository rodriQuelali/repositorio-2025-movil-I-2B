package com.example.calculadorapoo

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListView : AppCompatActivity() {

    private lateinit var listPaise:ListView


    private var listDataPaises = mutableListOf<String>()
    private var listaDataPoblacion = mutableListOf<Int>()

    lateinit var adapterArr: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cargarR()

        listDataPaises = mutableListOf<String>("Bolivia", "Argentina")
        listaDataPoblacion = mutableListOf<Int>(134455, 12222)

        adapterArr = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listDataPaises)
        listPaise.adapter = adapterArr

        listPaise.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "${listaDataPoblacion[position]}", Toast.LENGTH_SHORT).show()
        }
    }

    fun cargarR(){
        listPaise = findViewById(R.id.listViewPaise)
    }

    //tarea es agregar los datos de paises y poblacion atravez una caja de texto.
}