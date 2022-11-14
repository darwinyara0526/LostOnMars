package com.example.lostonmars.ui

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.lostonmars.R
import com.example.lostonmars.game.GameIntro
import java.util.*

class GameMainInterface : AppCompatActivity() {


    var timer: Timer? = null

    private lateinit var btnJugar: Button

    private lateinit var buttonPlay: Button
    private lateinit var buttonPause: Button
    private lateinit var buttonStop: Button


    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_main_interface)

        btnJugar = findViewById<Button>(R.id.btnJugar)

        btnJugar.setOnClickListener {
            val lanzar = Intent(this, GameIntro::class.java)
            startActivity(lanzar)
        }

        buttonPlay = findViewById(R.id.buttonPlay)
        buttonPause = findViewById(R.id.buttonPause)
        buttonStop = findViewById(R.id.buttonStop)

        mediaPlayer = MediaPlayer.create(this, R.raw.music)

        setOnClickListeners(this)


        //reproducir automaticamente
        timer = Timer()
        timer!!.schedule(object : TimerTask() {
            override fun run() {
                mediaPlayer?.start()
            }
        }, 1000)
    }

    private fun setOnClickListeners(context: Context) {
        buttonPlay.setOnClickListener {
            mediaPlayer.start()
        }

        buttonPause.setOnClickListener {
            mediaPlayer.pause()
        }

        buttonStop.setOnClickListener {
            mediaPlayer.stop()
            mediaPlayer = MediaPlayer.create(context, R.raw.music)
        }
    }

}