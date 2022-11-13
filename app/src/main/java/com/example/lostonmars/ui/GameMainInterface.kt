package com.example.lostonmars.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.lostonmars.R
import com.example.lostonmars.game.GameIntro
import com.example.lostonmars.game.GameMap1
import java.util.*

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
}