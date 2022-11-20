package com.example.lostonmars

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.lostonmars.ui.GameMainInterface

class Chaleco1Activity : AppCompatActivity() {

    private lateinit var btnEquipar: Button
    private lateinit var btnDesequipar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chaleco1)

        btnEquipar = findViewById(R.id.btnEquipar)
        btnEquipar.setOnClickListener {
            Toast.makeText(this, "Chaleco Equipado", Toast.LENGTH_SHORT).show()
            val lanzar = Intent(this, GameMainInterface::class.java)
            startActivity(lanzar)
        }
        btnDesequipar = findViewById(R.id.btnDesequipar)
        btnDesequipar.setOnClickListener {
            Toast.makeText(this, "Chaleco Desequipado", Toast.LENGTH_SHORT).show()
            val lanzar = Intent(this, GameMainInterface::class.java)
            startActivity(lanzar)
        }
    }
}