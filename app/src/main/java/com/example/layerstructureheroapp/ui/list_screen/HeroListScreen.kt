package com.example.layerstructureheroapp.ui.list_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import com.example.entities.heroListScreen.HeroListEvents
import com.example.entities.heroListScreen.HeroListState
import com.example.layerstructureheroapp.ui.list_screen.components.FilterMenu
import com.example.layerstructureheroapp.ui.list_screen.components.HeroListItem
import com.example.layerstructureheroapp.ui.list_screen.components.SearchBar
import com.example.layerstructureheroapp.ui.reusableComponent.CircularProgressBar
import com.example.entities.heroListScreen.FilterDialogState
import com.example.state.ProgressBarState

@ExperimentalComposeUiApi
@ExperimentalCoilApi
@Composable
fun HeroListScreen(
    heroListState: HeroListState,
    imageLoader: ImageLoader,
    onEventChange: (HeroListEvents) -> Unit
) {
    if (heroListState.progressBarState is ProgressBarState.Loading) {
        CircularProgressBar()
    } else {
        Column(modifier = Modifier.fillMaxSize()) {
            SearchBar(
                heroSearchQuery = heroListState.heroSearchQuery,
                onHeroSearchQueryChange = {
                    onEventChange(HeroListEvents.HeroQueryChange(it))
                },
                onExecuteSearchQuery = {
                    onEventChange(HeroListEvents.FilterHeroesByName)
                },
                onShowFilterDialog = {
                    onEventChange(HeroListEvents.ShowFilterDialog(filterDialogState = FilterDialogState.ShowFilterDialogState))
                }
            )

            LazyColumn {
                items(heroListState.filterHeroList) { item ->
                    HeroListItem(
                        hero = item,
                        imageLoader = imageLoader,
                        onItemClick = {
                            println("Clicked $it")
                        }
                    )
                }
            }
            if (heroListState.filterDialogState is FilterDialogState.ShowFilterDialogState) {
                FilterMenu(
                    onDismissFilterDialog = {
                        onEventChange(HeroListEvents.ShowFilterDialog(filterDialogState = FilterDialogState.HideFilterDialogState))
                    },
                    onSortDataChange = { sortState ->
                        onEventChange(HeroListEvents.SortAlphabetic(sortState))
                    }
                )
            }
        }
    }
}