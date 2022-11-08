package com.example.lostonmars.database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(Context: Context) :

    SQLiteOpenHelper(Context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {

        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "lostOnMars.db"
        private const val TB_JUGADOR = "player"
        private const val IDJUGADOR = "id"
        private const val NOMBREJUGADOR = "nombreJugador"
        private const val CORREOJUGADOR = "correoJugador"
        private const val CONTRASEÑAJUGADOR = "contraseñaJugador"
        private const val CONFIRMARCONTRASEÑA = "confirmarContraseña"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTbEcciStore = ("CREATE TABLE " + TB_JUGADOR +
                "(" + IDJUGADOR + " INTEGER PRIMARY KEY, " +
                NOMBREJUGADOR + " TEXT, " +
                CORREOJUGADOR + " TEXT, " +
                CONTRASEÑAJUGADOR + " TEXT, " +
                CONFIRMARCONTRASEÑA + " TEXT)")

        db?.execSQL(createTbEcciStore)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS " + TB_JUGADOR)
        onCreate(db)
    }

    fun insertProducts(std: PlayerModel): Long {

        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(IDJUGADOR, std.idJugador)
        contentValues.put(NOMBREJUGADOR, std.nombreJugador)
        contentValues.put(CORREOJUGADOR, std.correoJugador)
        contentValues.put(CONTRASEÑAJUGADOR, std.contraseñaJugador)
        contentValues.put(CONFIRMARCONTRASEÑA, std.confirmarContraseñaJugador)

        val success = db.insert(TB_JUGADOR, null,contentValues)
        db.close()

        return success
    }

    @SuppressLint("Range")
    fun getProducts(): ArrayList<PlayerModel>{
        val stdList: ArrayList<PlayerModel> = ArrayList()
        val selectQuery = "SELECT * FROM $TB_JUGADOR"
        val db = this.readableDatabase

        val cursor: Cursor?

        try{
            cursor = db.rawQuery(selectQuery, null)
        }catch (e:Exception){
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var idJugador:Int
        var nombreJugador:String
        var correoJugador:String
        var contraseñaJugador:String
        var confirmarContraseña:String

        if(cursor.moveToFirst()){
            do {
                idJugador = cursor.getInt(cursor.getColumnIndex("id"))
                nombreJugador = cursor.getString(cursor.getColumnIndex("nombreJugador"))
                correoJugador = cursor.getString(cursor.getColumnIndex("correoJugador"))
                contraseñaJugador = cursor.getString(cursor.getColumnIndex("contraseñaJugador"))
                confirmarContraseña = cursor.getString(cursor.getColumnIndex("confirmarContraseña"))


                val std = PlayerModel(idJugador = idJugador, nombreJugador = nombreJugador, correoJugador = correoJugador,
                    contraseñaJugador = contraseñaJugador, confirmarContraseñaJugador = confirmarContraseña)
                stdList.add(std)

            }while (cursor.moveToNext())
        }
        return stdList
    }

    fun deleteProductById(id:Int):Int{
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(IDJUGADOR, id)

        val success = db.delete(TB_JUGADOR,"id=$id",null)
        db.close()
        return success
    }

    fun checkPlayer(){

    }

}