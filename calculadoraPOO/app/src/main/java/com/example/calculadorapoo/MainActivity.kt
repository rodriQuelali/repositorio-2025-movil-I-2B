package com.example.calculadorapoo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

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
        val et2 = findViewById<TextInputEditText>(R.id.et1)
        val tvResul = findViewById<TextView>(R.id.tv1)
        val btnS = findViewById<Button>(R.id.btnSumar)

        btnS.setOnClickListener{
            val nro1:Int = et1.text.toString().toInt()
            val nro2:Int = et2.text.toString().toInt()
            val tota:Int = nro2+nro1
            tvResul.text = tota.toString()

        }




    }
}