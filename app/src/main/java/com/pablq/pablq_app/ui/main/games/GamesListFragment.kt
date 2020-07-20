package com.pablq.pablq_app.ui.main.games

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import com.pablq.pablq_app.R
import com.pablq.pablq_app.ui.main.Game
import com.pablq.pablq_app.ui.main.MainViewModel

class GamesListFragment: Fragment() {
    private val viewModel: MainViewModel by activityViewModels()

    private var games: MutableList<Game> = mutableListOf()

    private lateinit var gamesListAdapter: GamesListAdapter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val rootView = inflater.inflate(R.layout.games_list_fragment, container, false)
        val recyclerView = rootView.findViewById<RecyclerView>(R.id.gamesListRecyclerView)
        gamesListAdapter =
            GamesListAdapter(games) {
                // TODO: Launch browser
            }
        recyclerView.adapter = gamesListAdapter

        viewModel.games.observe(viewLifecycleOwner) {
            games.clear()
            games.addAll(it)
            gamesListAdapter.notifyDataSetChanged()
        }

        viewModel.isLoading.observe(viewLifecycleOwner) {
            // TODO: Show/Hide loading view.
        }

        return rootView
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadGames()
    }
}