package com.example.lostonmars.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lostonmars.R

class DeveloperView : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var adapter: PlayersInformation? = null

    private lateinit var sqLiteHelper: SQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_developer_view)

        initview()
        initRecyclerview()

        sqLiteHelper = SQLiteHelper(this)
        getInformation()

        adapter?.setOnClickDeleteItem {
            deleteProduct(it.idJugador)
        }
    }

    private fun initRecyclerview(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = PlayersInformation()
        recyclerView.adapter = adapter
    }

    private fun initview(){
        recyclerView = findViewById(R.id.recycleview)
    }

    private fun getInformation() {
        val stdList = sqLiteHelper.getProducts()
        Log.e("pppp","${stdList.size}")

        adapter?.addItems(stdList)
    }
    private fun deleteProduct(id:Int){
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Hey Desarrollador!! Seguro que quieres eliminar a este Jugador?")
        builder.setCancelable(true)
        builder.setPositiveButton("Si"){dialog,_ ->
            sqLiteHelper.deleteProductById(id)
            getInformation()
            dialog.dismiss()
        }
        builder.setNegativeButton("No"){dialog,_ ->
            dialog.dismiss()
        }

        val alert = builder.create()
        alert.show()

    }

}