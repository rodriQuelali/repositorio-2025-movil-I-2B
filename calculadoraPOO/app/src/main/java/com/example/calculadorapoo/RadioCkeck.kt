package com.example.calculadorapoo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadorapoo.data.Calculadora

class RadioCkeck : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radio_ckeck)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rbSuma = findViewById<RadioButton>(R.id.rbSuma)
        val rbResta = findViewById<RadioButton>(R.id.rbResta)

        val txt1 = findViewById<EditText>(R.id.txt1)
        val txt2 = findViewById<EditText>(R.id.edtxt2)

        val tvR = findViewById<TextView>(R.id.tvResul)

        val btnOpe = findViewById<Button>(R.id.btnOpeRadio)


        btnOpe.setOnClickListener {
            if(rbSuma.isChecked == true){
                tvR.text = Calculadora().suma(txt2.text.toString().toDouble(), txt1.text.toString().toDouble()).toString()
            }

            if(rbResta.isChecked == true){
                tvR.text = Calculadora().resta(txt2.text.toString().toDouble(), txt1.text.toString().toDouble())
            }
        }
    }
}