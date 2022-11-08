package com.example.lostonmars.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.lostonmars.R
import com.example.lostonmars.database.DeveloperView
import com.example.lostonmars.database.PlayerModel
import com.example.lostonmars.database.SQLiteHelper

class RegisterActivity : AppCompatActivity() {

    //References Layout
    private lateinit var edUsernameRegistrar: EditText
    private lateinit var edEmailRegistrar: EditText
    private lateinit var edPasswordRegistrar: EditText
    private lateinit var edPasswordRegistrar2: EditText
    private lateinit var btnRegisterRegistrar: Button
    private lateinit var btnViewRegistrar: Button
    private lateinit var btnIniciarRegistrar: Button

    private lateinit var sqLiteHelper: SQLiteHelper

    //private var adapter: ProductAdapter? = null

    //private var std:PlayerModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initView()
        sqLiteHelper = SQLiteHelper(this)

        btnRegisterRegistrar.setOnClickListener { registrarJugador() }
        btnViewRegistrar.setOnClickListener {
            val lanzar = Intent(this, DeveloperView::class.java)
            startActivity(lanzar)
        }
        btnIniciarRegistrar.setOnClickListener {
            val lanzar = Intent(this, LoginActivity::class.java)
            startActivity(lanzar)
        }

    }

    private fun registrarJugador(){

        val nameRegistrar = edUsernameRegistrar.text.toString()
        val EmailRegistrar = edEmailRegistrar.text.toString()
        val PasswordRegistrar = edPasswordRegistrar.text.toString()
        val PasswordRegistrar2 = edPasswordRegistrar2.text.toString()


        if(nameRegistrar.isEmpty() || EmailRegistrar.isEmpty() || PasswordRegistrar.isEmpty() || PasswordRegistrar2.isEmpty()){
            Toast.makeText(this, "Por Favor Complete Todos los campos", Toast.LENGTH_SHORT).show()
        }   else{

            if (PasswordRegistrar.equals(PasswordRegistrar2)){
                val std = PlayerModel(nombreJugador = nameRegistrar, correoJugador = EmailRegistrar, contraseñaJugador = PasswordRegistrar, confirmarContraseñaJugador = PasswordRegistrar2)
                val status = sqLiteHelper.insertProducts(std)

                if(status > -1){
                    Toast.makeText(this, "Usuario A sido Registrado", Toast.LENGTH_SHORT).show()
                    clearEditText()

                }else{
                    Toast.makeText(this, "Usuario no A sido Registrado", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"Error al confirmar Contraseña", Toast.LENGTH_SHORT).show()
                clearEditPassword()
            }

        }
    }

    private fun clearEditText(){
        edUsernameRegistrar.setText("")
        edEmailRegistrar.setText("")
        edPasswordRegistrar.setText("")
        edPasswordRegistrar2.setText("")
    }
    private fun clearEditPassword(){
        edPasswordRegistrar.setText("")
        edPasswordRegistrar2.setText("")
    }

    private fun initView(){

        edUsernameRegistrar = findViewById(R.id.edUsernameRegistrar)
        edEmailRegistrar = findViewById(R.id.edEmailRegistrar)
        edPasswordRegistrar = findViewById(R.id.edPasswordRegistrar)
        edPasswordRegistrar2 = findViewById(R.id.edPasswordRegistrar2)
        btnRegisterRegistrar = findViewById(R.id.btnRegisterRegistrar)
        btnViewRegistrar = findViewById(R.id.btnViewRegistrar)
        btnIniciarRegistrar = findViewById(R.id.btnIniciarRegistrar)

    }
}