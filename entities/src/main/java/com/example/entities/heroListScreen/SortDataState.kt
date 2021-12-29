package com.example.entities.heroListScreen

sealed class SortDataState {
    object Ascending : SortDataState()
    object Descending : SortDataState()
}