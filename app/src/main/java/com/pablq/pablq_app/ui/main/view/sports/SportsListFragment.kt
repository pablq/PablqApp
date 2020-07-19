package com.pablq.pablq_app.ui.main.view.sports

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.pablq.pablq_app.R
import com.pablq.pablq_app.ui.main.MainViewModel
import com.pablq.pablq_app.ui.main.Sport

class SportsListFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val rootView = inflater.inflate(R.layout.sports_list_fragment, container, false)

        val recyclerView = rootView.findViewById<RecyclerView>(R.id.sportsListRecyclerView)

        val sportsListAdapter = SportsListAdapter(viewModel.allSports, {
            handleSportSelected(it)
        })

        recyclerView.adapter = sportsListAdapter

        return rootView
    }

    private fun handleSportSelected(sport: Sport) {
        viewModel.selectedSport.value = sport
        // TODO: Shows games list view
    }
}