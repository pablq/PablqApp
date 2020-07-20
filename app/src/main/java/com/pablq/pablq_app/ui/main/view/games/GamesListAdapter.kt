package com.pablq.pablq_app.ui.main.view.games

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.pablq.pablq_app.R
import com.pablq.pablq_app.R.layout.game_card
import com.pablq.pablq_app.ui.main.Game

class GamesListAdapter(
    private val gamesList: List<Game>,
    private val onClickHandler: (Game) -> Unit
) : RecyclerView.Adapter<GamesListAdapter.GameCardViewHolder>() {

    // TODO: Custom Game Card class?
    inner class GameCardViewHolder(
        private val containerView: CardView,
        private val headlineTextView: TextView,
        private val descriptionTextView: TextView,
        private val linkTextView: TextView,
        private val onClickHandler: (Game) -> Unit
    ) : RecyclerView.ViewHolder(containerView) {

        fun bind(game: Game) {
            headlineTextView.text = game.headline
            if (game.description.isNotEmpty()) {
                descriptionTextView.text = game.description
                descriptionTextView.visibility = View.VISIBLE
            } else {
                descriptionTextView.visibility = View.GONE
            }
            linkTextView.text = game.uri.toString()
            linkTextView.setOnClickListener {
                onClickHandler(game)
            }
            val backgroundColor = if (game.isFavorite) Color.RED else Color.GRAY
            containerView.setCardBackgroundColor(backgroundColor)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameCardViewHolder {
        val containerView = LayoutInflater.from(parent.context).inflate(game_card, parent, false) as CardView
        val headlineTextView = containerView.findViewById<TextView>(R.id.gameHeadline)
        val descriptionTextView = containerView.findViewById<TextView>(R.id.gameDescription)
        val linkTextView = containerView.findViewById<TextView>(R.id.gameLink)
        return GameCardViewHolder(containerView, headlineTextView, descriptionTextView, linkTextView, onClickHandler)
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

    override fun onBindViewHolder(holder: GameCardViewHolder, position: Int) {
        holder.bind(gamesList[position])
    }
}