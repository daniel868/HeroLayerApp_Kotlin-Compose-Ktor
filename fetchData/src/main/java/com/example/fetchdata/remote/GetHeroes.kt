package com.example.fetchdata.remote

import android.util.Log
import com.example.datasource.remote.HeroService
import com.example.entities.hero.Hero
import com.example.state.DataState
import com.example.state.ProgressBarState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

private const val TAG = "GetHeroes"

class GetHeroes(
    private val heroService: HeroService
) {

    fun getHeroesList(): Flow<DataState<List<Hero>>> = flow {
        try {
            //emit loading state
            emit(DataState.Loading<List<Hero>>(progressBarState = ProgressBarState.Loading))

            val heroList: List<Hero> = try {
                heroService.getHeroes()
            } catch (e: Exception) {
                e.printStackTrace()

                listOf()
            }

            if (heroList.isEmpty())
                emit(DataState.Response<List<Hero>>(value = "Error getting list "))
            else
                emit(DataState.Data(data = heroList))


        } catch (e: Exception) {
            emit(
                DataState.Response<List<Hero>>(
                    value = "Error getting list"
                )
            )
        } finally {
            //add finally state
            emit(DataState.Loading<List<Hero>>(progressBarState = ProgressBarState.Idle))
        }
    }.catch { e ->
        Log.e(TAG, "getHeroesList: ", e)
    }

}