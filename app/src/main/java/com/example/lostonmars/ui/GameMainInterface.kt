package com.example.lostonmars.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.lostonmars.*
import com.example.lostonmars.game.GameIntro

class GameMainInterface : AppCompatActivity() {

    private lateinit var btnJugar: Button
    private lateinit var btnSetting:Button
    private lateinit var btnLogros1:Button
    private lateinit var btnNarracion:Button
    private lateinit var btnReglas:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_main_interface)

        btnJugar = findViewById(R.id.btnJugar)
        btnSetting = findViewById(R.id.btnSetting)
        btnLogros1 = findViewById(R.id.btnLogros1)
        btnNarracion = findViewById(R.id.btnNarracion)
        btnReglas = findViewById(R.id.btnReglas)

        btnJugar.setOnClickListener {
            val lanzar = Intent(this, GameIntro::class.java)
            startActivity(lanzar)
        }
        btnSetting.setOnClickListener {
            val lanzar = Intent(this, SettingActivity::class.java)
            startActivity(lanzar)
        }
        btnLogros1.setOnClickListener {
            val lanzar = Intent(this, LogrosActivity::class.java)
            startActivity(lanzar)
        }
        btnNarracion.setOnClickListener {
            val lanzar = Intent(this, NarraccionActivity::class.java)
            startActivity(lanzar)
        }
        btnReglas.setOnClickListener {
            val lanzar = Intent(this, ReglasActivity::class.java)
            startActivity(lanzar)
        }
    }
}