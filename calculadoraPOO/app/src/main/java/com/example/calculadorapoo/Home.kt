package com.example.calculadorapoo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCal= findViewById<Button>(R.id.btnCal)
        val btnRC= findViewById<Button>(R.id.btnRarioCheck)
        val btnSpinner = findViewById<Button>(R.id.btnSpinner)
        val btnListView = findViewById<Button>(R.id.ListView)

        btnCal.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

        btnRC.setOnClickListener {
            val i = Intent(this, RadioCkeck::class.java)
            startActivity(i)
        }

        btnSpinner.setOnClickListener {
            val i= Intent(this, spinner::class.java)
            startActivity(i)
        }

        btnListView.setOnClickListener {
            val i = Intent(this, ListView::class.java)
            startActivity(i)
        }
    }
}