package com.example.lostonmars.database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lostonmars.R

class PlayersInformation : RecyclerView.Adapter<PlayersInformation.ProductViewHolder>() {

    private var stdList: ArrayList<PlayerModel> = ArrayList()
    private var onClickDeleteItem:((PlayerModel) -> Unit)? = null

    fun addItems(items: ArrayList<PlayerModel>){
        this.stdList = items
        notifyDataSetChanged()
    }

    fun setOnClickDeleteItem(callback: (PlayerModel) -> Unit){
        this.onClickDeleteItem = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ProductViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.activity_registered_players, parent, false)
    )

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val std = stdList[position]
        holder.bindView(std)
        holder.btnDelete.setOnClickListener { onClickDeleteItem?.invoke(std) }
    }

    override fun getItemCount(): Int {
        return stdList.size

    }

    class ProductViewHolder(var view: View) : RecyclerView.ViewHolder(view){

        private var id = view.findViewById<TextView>(R.id.tvId)
        private var UsernamePlayers = view.findViewById<TextView>(R.id.tvUsernamePlayers)
        private var EmailPlayers = view.findViewById<TextView>(R.id.tvEmailPlayers)
        private var PasswordPlayers = view.findViewById<TextView>(R.id.tvPasswordPlayers)
        var btnDelete = view.findViewById<Button>(R.id.btnDelete)

        fun bindView(std: PlayerModel){
            id.text = std.idJugador.toString()
            UsernamePlayers.text = std.nombreJugador
            EmailPlayers.text = std.correoJugador
            PasswordPlayers.text = std.contraseñaJugador
        }

    }
}