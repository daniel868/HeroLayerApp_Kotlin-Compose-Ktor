package com.example.layerstructureheroapp.ui.list_screen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.entities.hero.Hero
import com.example.entities.heroListScreen.HeroListEvents
import com.example.entities.heroListScreen.HeroListState
import com.example.fetchdata.filter.FilterHeroes
import com.example.fetchdata.remote.GetHeroes
import com.example.state.DataState
import com.example.entities.heroListScreen.FilterDialogState
import com.example.state.ProgressBarState
import com.example.entities.heroListScreen.SortDataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "HeroListViewModel"

@HiltViewModel
class HeroListViewModel @Inject constructor(
    private val getHeroes: GetHeroes,
    private val filterHeroes: FilterHeroes
) : ViewModel() {

    val heroesState: MutableState<HeroListState> = mutableStateOf(HeroListState())

    init {
        onEventChange(HeroListEvents.GetHeroes)
    }

    fun onEventChange(heroListEvents: HeroListEvents) {
        when (heroListEvents) {
            HeroListEvents.GetHeroes -> {
                executeGetHeroes()
            }
            is HeroListEvents.HeroQueryChange -> {
                onHeroQueryChange(heroListEvents.newValue)
            }
            HeroListEvents.FilterHeroesByName -> {
                filterHeroByName()
            }
            is HeroListEvents.ShowFilterDialog -> {
                handleDisplayMenuEvents(heroListEvents.filterDialogState)
            }
            is HeroListEvents.SortAlphabetic -> {
                handleSortAlphabeticEvent(heroListEvents.sortDataState)
            }
        }
    }

    private fun executeGetHeroes() {
        viewModelScope.launch {
            getHeroes.getHeroesList().collect { dataState ->
                when (dataState) {
                    is DataState.Data -> {
                        heroesState.value =
                            heroesState.value.copy(heroes = dataState.data ?: listOf())
                        heroesState.value =
                            heroesState.value.copy(filterHeroList = dataState.data ?: listOf())
                    }
                    is DataState.Loading -> {
                        when (dataState.progressBarState) {
                            ProgressBarState.Idle -> {
                                Log.d(TAG, "Idle state")
                            }
                            ProgressBarState.Loading -> {
                                Log.d(TAG, "Loading state ")
                            }
                        }
                        heroesState.value =
                            heroesState.value.copy(progressBarState = dataState.progressBarState)
                    }
                    is DataState.Response -> {
                        heroesState.value = heroesState.value.copy(value = dataState.value)
                        Log.d(TAG, "Message: " + dataState.value)
                    }
                }
            }
        }

    }

    private fun onHeroQueryChange(newValue: String) {
        heroesState.value = heroesState.value.copy(heroSearchQuery = newValue)
    }

    private fun filterHeroByName() {
        val filteredList: List<Hero> =
            filterHeroes.filterHeroes(
                searchQuery = heroesState.value.heroSearchQuery,
                currentHeroList = heroesState.value.heroes,
                sortDataState = heroesState.value.sortDataState
            )
        heroesState.value = heroesState.value.copy(filterHeroList = filteredList)
    }

    private fun handleDisplayMenuEvents(filterDialogState: FilterDialogState) {
        heroesState.value = heroesState.value.copy(filterDialogState = filterDialogState)
    }

    private fun handleSortAlphabeticEvent(sortDataState: SortDataState) {
        heroesState.value = heroesState.value.copy(sortDataState = sortDataState)
        filterHeroByName()
    }
}