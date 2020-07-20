package com.pablq.pablq_app.ui.main.view.sports

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pablq.pablq_app.R
import com.pablq.pablq_app.ui.main.Sport

class SportsListAdapter(private val sportsList: List<Sport>, private val onClickHandler: (Sport) -> Unit) : RecyclerView.Adapter<SportsListAdapter.SportCardViewHolder>() {

    inner class SportCardViewHolder(
        private val textView: TextView,
        private val onClickHandler: (Sport) -> Unit
    ) : RecyclerView.ViewHolder(textView) {

        fun bind(sport: Sport) {
            textView.text = sport.league
            textView.setOnClickListener {
                onClickHandler(sport)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportCardViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.sport_card, parent, false) as TextView
        return SportCardViewHolder(textView, onClickHandler)
    }

    override fun getItemCount(): Int {
        return sportsList.size
    }

    override fun onBindViewHolder(holder: SportCardViewHolder, position: Int) {
        holder.bind(sportsList[position])
    }
}