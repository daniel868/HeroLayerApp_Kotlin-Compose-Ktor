package com.example.fetchdata.filter

import com.example.entities.hero.Hero
import com.example.entities.heroListScreen.SortDataState

class FilterHeroes {
    fun filterHeroes(
        searchQuery: String,
        currentHeroList: List<Hero>,
        sortDataState: SortDataState
    ): List<Hero> {
        val filteredHeroList: MutableList<Hero> = currentHeroList.filter { currentHero ->
            currentHero.localizedName.lowercase().contains(searchQuery)
        }.toMutableList()

        when (sortDataState) {
            SortDataState.Ascending -> {
                filteredHeroList.sortBy {
                    it.localizedName
                }
            }
            SortDataState.Descending -> {
                filteredHeroList.sortByDescending {
                    it.localizedName
                }
            }
        }

        return filteredHeroList
    }
}