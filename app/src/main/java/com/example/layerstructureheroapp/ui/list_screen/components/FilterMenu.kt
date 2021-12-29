package com.example.layerstructureheroapp.ui.list_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.entities.heroListScreen.SortDataState

@Composable
fun FilterMenu(
    onDismissFilterDialog: () -> Unit,
    onSortDataChange: (SortDataState) -> Unit
) {
    AlertDialog(
        modifier = Modifier.padding(16.dp),
        onDismissRequest = {
            onDismissFilterDialog()
        },
        title = {
            Text(text = "More filter options", style = MaterialTheme.typography.h6)
        },
        text = {
            Row(modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = {
                        onSortDataChange(SortDataState.Ascending)
                        onDismissFilterDialog()
                    },
                    modifier = Modifier.padding(8.dp),
                    content = {
                        Text(text = "Sort a-z")
                    }
                )
                Button(
                    onClick = {
                        onSortDataChange(SortDataState.Descending)
                        onDismissFilterDialog()
                    },
                    modifier = Modifier.padding(8.dp),
                    content = {
                        Text(text = "Sort z-a")
                    }
                )

            }
        },
        buttons = {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .align(Alignment.End)
                        .clickable {
                            onDismissFilterDialog()
                        }
                ) {
                    Icon(
                        modifier = Modifier.padding(16.dp),
                        imageVector = Icons.Default.Check,
                        contentDescription = "Done",
                        tint = Color(0xFF009a34)
                    )
                }
            }
        }
    )
}