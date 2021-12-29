package com.example.entities.heroListScreen

sealed class HeroListEvents {
    object GetHeroes : HeroListEvents()

    object FilterHeroesByName : HeroListEvents()

    data class ShowFilterDialog(
        val filterDialogState: FilterDialogState
    ) : HeroListEvents()

    data class HeroQueryChange(
        val newValue: String
    ) : HeroListEvents()

    data class SortAlphabetic(
        val sortDataState: SortDataState
    ) : HeroListEvents()
}
