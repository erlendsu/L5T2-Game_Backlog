package com.auas.aad.gamebacklog.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.auas.aad.gamebacklog.model.Game
import kotlinx.android.synthetic.main.content_item.view.*
import java.text.SimpleDateFormat

class GameAdapter(private val games: List<Game>) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(com.auas.aad.gamebacklog.R.layout.content_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(games[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(game: Game) {
            val releaseDate = SimpleDateFormat("dd MMMM yyyy").format(game.releaseDate)

            itemView.tvTitle.text = game.title
            itemView.tvPlatform.text = game.platform
            itemView.tvReleaseDate.text = releaseDate
        }
    }
}
