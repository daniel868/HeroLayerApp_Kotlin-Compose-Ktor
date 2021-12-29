package com.example.layerstructureheroapp.ui.list_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalComposeUiApi
@Composable
fun SearchBar(
    heroSearchQuery: String,
    onHeroSearchQueryChange: (String) -> Unit,
    onExecuteSearchQuery: () -> Unit,
    onShowFilterDialog: () -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(modifier = Modifier.fillMaxWidth()) {
        TextField(
            value = heroSearchQuery,
            onValueChange = { newValue ->
                onHeroSearchQueryChange(newValue)
                onExecuteSearchQuery()
            },
            modifier = Modifier
                .fillMaxWidth(.9f)
                .padding(8.dp),
            label = {
                Text(text = "Search for hero")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    //todo: do something
                    keyboardController?.hide()
                    onExecuteSearchQuery()
                }
            ),
            leadingIcon = {
                Icon(Icons.Filled.Search, contentDescription = "Search Icon")
            },
            textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
            colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface)
        )
        Icon(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterVertically)
                .clickable {
                    onShowFilterDialog()
                },
            imageVector = Icons.Filled.MoreVert,
            contentDescription = "Filter Icon",
        )
    }
}