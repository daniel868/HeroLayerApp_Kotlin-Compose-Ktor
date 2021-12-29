package com.example.layerstructureheroapp.ui.list_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.entities.hero.Hero
import kotlin.math.round

@ExperimentalCoilApi
@Composable
fun HeroListItem(
    hero: Hero,
    imageLoader: ImageLoader,
    onItemClick: (Int) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .clickable {
                onItemClick(hero.id)
            }
            .background(MaterialTheme.colors.onSurface),
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val painter = rememberImagePainter(hero.img, imageLoader = imageLoader)
            Image(
                modifier = Modifier
                    .width(120.dp)
                    .height(70.dp)
                    .background(Color.LightGray),
                painter = painter,
                contentDescription = hero.localizedName,
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(.8f)
                    .padding(start = 12.dp)
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 4.dp),
                    style = MaterialTheme.typography.h6,
                    text = hero.localizedName

                )
                Text(text = hero.primaryAttribute.value)
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 12.dp),
                horizontalAlignment = Alignment.End
            ) {
                val winRate: Int =
                    round(hero.proWins.toDouble() / hero.proPick.toDouble() * 100).toInt()
                val color: Color =
                    if (winRate > 50) Color(0xFF009a34) else MaterialTheme.colors.error
                Text(
                    text = "$winRate %",
                    color = color,
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }


}