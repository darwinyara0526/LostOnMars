package com.example.lostonmars.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.lostonmars.GameIntro
import com.example.lostonmars.R

class GameMainInterface : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_main_interface)

        var btnJugar = findViewById<Button>(R.id.btnJugar)

        btnJugar.setOnClickListener {
            val lanzar = Intent(this, GameIntro::class.java)
            startActivity(lanzar)
        }

    }
    fun esperar() {
        try {
            Thread.sleep((4 * 1000).toLong())
        } catch (e: Exception) {
            println(e)
        }
    }
}