package com.pablq.pablq_app.ui.main

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainViewModel : ViewModel() {
    val allSports = listOf(
        Sport("mlb", "baseball"),
        Sport("nhl", "puck"),
        Sport("nfl", "football"),
        Sport("nba", "basketball")
    )

    val selectedSport = MutableLiveData<Sport?>()

    val games = MutableLiveData<List<Game>>()

    val isLoading = MutableLiveData<Boolean>()

    private val repository: IMainRespository = MainRepository()

    fun loadGames() {
        val league = selectedSport.value?.league
        if (league != null) {
            isLoading.value = true
            games.value = repository.getGames(league) ?: listOf()
            isLoading.value = false
        }
    }

    fun wakeUp() {
        repository.wakeUp()
    }
}

interface IMainRespository {
    fun wakeUp()
    fun getGames(league: String): List<Game>?
}

class MainRepository: IMainRespository {
    override fun wakeUp() {
        // do nothing.
    }

    override fun getGames(league: String): List<Game>? {
        return listOf(
            Game("headline1", listOf("line1","line2"), "http://www.pablq.website"),
            Game("headline2", listOf(), "http://www.pablq.website"),
            Game("headline3", listOf("line1","line2", "line3"), "http://www.pablq.website")
        )
    }
}

data class Sport(val league: String, val imageName: String)

data class Game(
    val headline: String,
    private val lines: List<String>,
    private val link: String) {

    val description = lines.joinToString("\n")
    val isFavorite = headline.toLowerCase(Locale.ROOT).contains("chicago")
    val uri: Uri = Uri.parse(link)
}