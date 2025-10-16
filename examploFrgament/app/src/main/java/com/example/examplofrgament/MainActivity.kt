package com.example.examplofrgament

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        val btns1 = findViewById<Button>(R.id.btnS1)
        val btns2 = findViewById<Button>(R.id.btnS2)

        btns2.setOnClickListener {
            //primero debo hacer la instancia de mi clase frgament
            val salu2 = saludodos()
            supportFragmentManager.beginTransaction()
                .replace(R.id.frmEmpresaContent, salu2)
                .addToBackStack(null)
                .commit()
        }

        btns1.setOnClickListener {
            //primero debo hacer la instancia de mi clase frgament
            val salu2 = saludoFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.frmEmpresaContent, salu2)
                .addToBackStack(null)
                .commit()
        }
    }


}