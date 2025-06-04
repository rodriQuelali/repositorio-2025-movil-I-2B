package com.example.calculadorapoo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadorapoo.data.Calculadora
import com.google.android.material.textfield.TextInputEditText

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



        val et1 = findViewById<TextInputEditText>(R.id.et1)
        val et2 = findViewById<TextInputEditText>(R.id.et2)
        val tvResul = findViewById<TextView>(R.id.tv1)
        val btnS = findViewById<Button>(R.id.btnSumar)

        /*
        * Confeccionar la siguiente ejercicio:
        *
        * POO - Calculadora
        * Sobrecarga de metodos.
        *
        * Resta
        * Multiplicacion
        * Division
        *
        * Imput:
        * a = 2
        * b = 2
        *
        * a = 2
        * b = 2.4
        *
        * OUTPUT
        * resta : 0
        * Multplicacion: 4
        * Divisio: 1
        *
        * resta : -0.4
        * Multplicacion: 4.8
        * Divisio: 1.2
        *
        * */

        btnS.setOnClickListener{

            val resul: String = Calculadora().suma(et1.text.toString().toDouble(), et2.text.toString().toDouble())
            tvResul.text = resul.toString()

        }

    }
}