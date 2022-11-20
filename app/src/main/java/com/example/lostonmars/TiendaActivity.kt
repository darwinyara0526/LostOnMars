package com.example.lostonmars

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TiendaActivity : AppCompatActivity() {

    private lateinit var arma1: Button
    private lateinit var casco1:Button
    private lateinit var chaleco1:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tienda)

        arma1 = findViewById(R.id.arma1)
        casco1 = findViewById(R.id.casco1)
        chaleco1 = findViewById(R.id.chaleco1)

        arma1.setOnClickListener {
            val lanzar = Intent(this, Arma1Activity::class.java)
            startActivity(lanzar)
        }

        casco1 = findViewById<Button>(R.id.casco1)
        casco1.setOnClickListener {
            val lanzar = Intent(this, Casco1Activity::class.java)
            startActivity(lanzar)
        }

        chaleco1 = findViewById(R.id.chaleco1)
        chaleco1.setOnClickListener {
            val lanzar = Intent(this, Chaleco1Activity::class.java)
            startActivity(lanzar)
        }
    }
}