package com.example.layerstructureheroapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import com.example.layerstructureheroapp.ui.list_screen.HeroListScreen
import com.example.layerstructureheroapp.ui.list_screen.HeroListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "MainActivity"

@AndroidEntryPoint
@ExperimentalCoilApi
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    private val heroListViewModel: HeroListViewModel by viewModels()

    @Inject
    lateinit var imageLoader: ImageLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HeroListScreen(
                heroListState = heroListViewModel.heroesState.value,
                imageLoader = imageLoader,
                onEventChange = { currentEvent ->
                    heroListViewModel.onEventChange(currentEvent)
                }
            )
        }
    }
}
