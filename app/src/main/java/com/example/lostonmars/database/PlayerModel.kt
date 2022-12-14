package com.example.lostonmars.database

import java.util.*

data class PlayerModel (
    val idJugador: Int = getAutoID(),
    val nombreJugador:String = "",
    val correoJugador:String = "",
    val contrase├▒aJugador:String = "",
    val confirmarContrase├▒aJugador:String = ""
) {
    companion object{
        fun getAutoID():Int{
            val random = Random()
            return random.nextInt(1000)
        }
    }
}