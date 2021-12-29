package com.example.state

sealed class ProgressBarState {
    object Loading : ProgressBarState()

    object Idle : ProgressBarState()
}
