package com.example.lostonmars

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.lostonmars.ui.LoginActivity
import com.example.lostonmars.ui.RegisterActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //RedesSociales

        redesSociales()
        //Botones

        var btnIniciarPortada = findViewById<Button>(R.id.btnIniciarPortada)
        btnIniciarPortada.setOnClickListener {
            val lanzar = Intent(this, LoginActivity::class.java)
            startActivity(lanzar)
        }

        var btnRegistrarPortada = findViewById<Button>(R.id.btnRegistrarPortada)
        btnRegistrarPortada.setOnClickListener {
            val lanzar = Intent(this, RegisterActivity::class.java)
            startActivity(lanzar)
        }
    }

    fun redesSociales(){

        var btnFacebookPortada = findViewById<Button>(R.id.btnFacebook)
        btnFacebookPortada.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"))
            startActivity(browserIntent)

        }
        var btnInstagramPortada = findViewById<Button>(R.id.btnInstagram)
        btnInstagramPortada.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com"))
            startActivity(browserIntent)

        }
        var btnYoutubePortada = findViewById<Button>(R.id.btnYoutube)
        btnYoutubePortada.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com"))
            startActivity(browserIntent)

        }
        var btnTikTokPortada = findViewById<Button>(R.id.btnTikTok)
        btnTikTokPortada.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tiktok.com"))
            startActivity(browserIntent)

        }
    }

}