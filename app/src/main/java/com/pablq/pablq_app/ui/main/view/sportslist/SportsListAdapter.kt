package com.pablq.pablq_app.ui.main.view.sportslist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pablq.pablq_app.R

class SportsListAdapter(private val sportsList: Array<String>) : RecyclerView.Adapter<SportsListAdapter.SportCardViewHolder>() {

    class SportCardViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportCardViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.sport_card, parent, false) as TextView

        return SportCardViewHolder(textView)
    }

    override fun getItemCount(): Int {
        return sportsList.size
    }

    override fun onBindViewHolder(holder: SportCardViewHolder, position: Int) {
        holder.textView.text = sportsList[position]
    }
}