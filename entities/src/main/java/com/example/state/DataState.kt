package com.example.state

sealed class DataState<T> {
    data class Response<T>(
        val value: String
    ) : DataState<T>()

    data class Data<T>(
        val data: T? = null
    ) : DataState<T>()

    data class Loading<T>(
        val progressBarState: ProgressBarState = ProgressBarState.Loading
    ) : DataState<T>()
}
