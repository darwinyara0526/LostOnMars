package com.example.lostonmars

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.lostonmars.ui.GameMainInterface
import com.example.lostonmars.ui.RegisterActivity
import java.util.*

class SettingActivity : AppCompatActivity() {

    private lateinit var buttonPlay: Button
    private lateinit var buttonPause: Button
    private lateinit var buttonStop: Button
    private lateinit var enviarMensaje:Button
    private lateinit var mensajeEscrito: EditText

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)


        buttonPlay = findViewById(R.id.buttonPlay)
        buttonPause = findViewById(R.id.buttonPause)
        buttonStop = findViewById(R.id.buttonStop)
        enviarMensaje = findViewById(R.id.enviarMensaje)
        mensajeEscrito = findViewById(R.id.mensajeEscrito)

        mediaPlayer = MediaPlayer.create(this, R.raw.music)

        setOnClickListeners(this)

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
        enviarMensaje.setOnClickListener {
            Toast.makeText(this,"Mensaje Enviado", Toast.LENGTH_SHORT).show()
            mensajeEscrito.setText("")
            val lanzar = Intent(this, GameMainInterface::class.java)
            startActivity(lanzar)
        }
    }
}