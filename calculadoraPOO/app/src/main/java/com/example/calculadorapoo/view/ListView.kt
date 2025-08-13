package com.example.calculadorapoo.view

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadorapoo.R
import com.example.calculadorapoo.data.Pais

class ListView : AppCompatActivity() {

    private lateinit var listPaise:ListView
    private lateinit var txtPais:EditText
    private lateinit var txtPobla:EditText
    private lateinit var btnAgregarPais:Button


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
        estadoButon()

        listDataPaises = mutableListOf<String>()
        listaDataPoblacion = mutableListOf<Int>()

        adapterArr = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listDataPaises)
        listPaise.adapter = adapterArr

        listPaise.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "${listaDataPoblacion[position]}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun cargarR(){
        listPaise = findViewById(R.id.listViewPaise)
        txtPais=findViewById(R.id.txtPais)
        txtPobla=findViewById(R.id.txtPoblacion)
        btnAgregarPais=findViewById(R.id.btnInPais)
    }

    private fun estadoButon(){
        btnAgregarPais.setOnClickListener {
            val paisNuevo:Pais = Pais(txtPais.text.toString(), txtPobla.text.toString().toInt())
            listDataPaises.add(paisNuevo.getNombre())
            listaDataPoblacion.add(paisNuevo.getPoblacion())
            listPaise.adapter = adapterArr

            txtPais.text.clear()
            txtPobla.text.clear()
        }
    }

    //tarea es agregar los datos de paises y poblacion atravez una caja de texto.
}