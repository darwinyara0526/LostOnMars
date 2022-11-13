package com.example.lostonmars.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lostonmars.R
import com.example.lostonmars.database.DeveloperView
import com.example.lostonmars.database.PlayerModel
import com.example.lostonmars.database.SQLiteHelper

class LoginActivity : AppCompatActivity() {

    private lateinit var sqLiteHelper: SQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var edUsernameRegistrar = findViewById<TextView>(R.id.edUsernameRegistrar)
        var edPasswordRegistrar = findViewById<TextView>(R.id.edPasswordRegistrar)
        var btnLoginIngresar = findViewById<Button>(R.id.btnLoginIngresar)
        var btnRegistrateIngresar = findViewById<Button>(R.id.btnRegistrateIngresar)

        val helper = SQLiteHelper(applicationContext)
        var db = helper.readableDatabase

        btnLoginIngresar.setOnClickListener {
            var args = listOf<String>(edUsernameRegistrar.text.toString(),edPasswordRegistrar.text.toString()).toTypedArray()
            var rs = db.rawQuery("SELECT * FROM player WHERE nombreJugador = ? AND contraseñaJugador = ?",args)
            if (rs.moveToNext()){
                val lanzar = Intent(this, GameMainInterface::class.java)
                startActivity(lanzar)
            }else{
                Toast.makeText(applicationContext, "invalid credential", Toast.LENGTH_SHORT).show()
            }
        }
        btnRegistrateIngresar.setOnClickListener {
            val lanzar = Intent(this, RegisterActivity::class.java)
            startActivity(lanzar)
        }
    }
}