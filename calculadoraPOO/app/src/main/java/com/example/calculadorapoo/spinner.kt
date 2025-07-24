package com.example.calculadorapoo

import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class spinner : AppCompatActivity() {
    private lateinit var spinner:Spinner
    private lateinit var txtInsertar:EditText
    private lateinit var btnInserter:Button

    var listData = mutableListOf<String>()
    lateinit var adapterArr:ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spinner)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        cargarR()

        listData = mutableListOf<String>("Suma", "resta", "Multiplocacion", "Division")
        adapterArr = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,listData)
        spinner.adapter = adapterArr

        estadoSpinner()

        estadoBoton()



    }


    fun cargarR(){

        spinner = findViewById(R.id.spinnerCal)
        txtInsertar = findViewById(R.id.txtInsertar)
        btnInserter = findViewById(R.id.btnInsertar)
    }

    fun estadoBoton(){

        btnInserter.setOnClickListener {
            listData.add(txtInsertar.text.toString())
            spinner.adapter = adapterArr
        }

        //mas estados butonnnn....
    }

    fun estadoSpinner(){
        spinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                Toast.makeText(this@spinner, "$selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }
}