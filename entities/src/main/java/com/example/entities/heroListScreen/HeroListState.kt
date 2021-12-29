package com.example.entities.heroListScreen

import com.example.entities.hero.Hero
import com.example.state.ProgressBarState

data class HeroListState(
    val heroes: List<Hero> = listOf(),
    val filterHeroList: List<Hero> = listOf(),
    val value: String = "",
    val heroSearchQuery: String = "",
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val filterDialogState: FilterDialogState = FilterDialogState.HideFilterDialogState,
    val sortDataState: SortDataState = SortDataState.Ascending
)
