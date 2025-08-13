package com.example.calculadorapoo.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadorapoo.R
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
        //val btnS = findViewById<Button>(R.id.btnSumar)

        val btnS = findViewById<Button>(R.id.btS)
        val btnR = findViewById<Button>(R.id.btR)
        val btnM = findViewById<Button>(R.id.btM)
        val btnD = findViewById<Button>(R.id.btD)

        val btnUno = findViewById<Button>(R.id.btUno)

        var txt=""
        btnUno.setOnClickListener {
            txt += "1"
            et1.setText(txt)
        }


        btnS.setOnClickListener{
            val resul: String = Calculadora().suma(et1.text.toString().toDouble(), et2.text.toString().toDouble())
            tvResul.text = resul.toString()
        }

        btnR.setOnClickListener{
            val resul: String = Calculadora().resta(et1.text.toString().toDouble(), et2.text.toString().toDouble())
            tvResul.text = resul.toString()
        }

        btnM.setOnClickListener{
            val resul: String = Calculadora().multi(et1.text.toString().toDouble(), et2.text.toString().toDouble())
            tvResul.text = resul.toString()
        }

        btnD.setOnClickListener{
            val resul: String = Calculadora().divi(et1.text.toString().toDouble(), et2.text.toString().toDouble())
            tvResul.text = resul.toString()
        }

    }
}