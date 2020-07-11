package com.pablq.pablq_app.ui.main.view.sportslist

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pablq.pablq_app.R
import com.pablq.pablq_app.ui.main.MainViewModel

class SportsListFragment : Fragment() {

    companion object {
        fun newInstance() =
            SportsListFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val rootView = inflater.inflate(R.layout.sports_list_fragment, container, false)

        val recyclerView = rootView.findViewById<RecyclerView>(R.id.sportsListRecyclerView)

        val data = arrayOf("hello", "hello again", "third element")

        val sportsListAdapter = SportsListAdapter(sportsList = data)

        recyclerView.adapter = sportsListAdapter

        recyclerView.layoutManager = LinearLayoutManager(activity)

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}