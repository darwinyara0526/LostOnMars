package com.example.lostonmars.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.lostonmars.R
import com.example.lostonmars.SettingActivity
import com.example.lostonmars.game.GameIntro

class GameMainInterface : AppCompatActivity() {

    private lateinit var btnJugar: Button
    private lateinit var btnSetting:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_main_interface)

        btnJugar = findViewById(R.id.btnJugar)
        btnSetting = findViewById(R.id.btnSetting)

        btnJugar.setOnClickListener {
            val lanzar = Intent(this, GameIntro::class.java)
            startActivity(lanzar)
        }
        btnSetting.setOnClickListener {
            val lanzar = Intent(this, SettingActivity::class.java)
            startActivity(lanzar)
        }
    }
}