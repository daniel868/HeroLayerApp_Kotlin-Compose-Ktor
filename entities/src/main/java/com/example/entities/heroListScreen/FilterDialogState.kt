package com.example.entities.heroListScreen

sealed class FilterDialogState {
    object ShowFilterDialogState : FilterDialogState()

    object HideFilterDialogState : FilterDialogState()
}
