package com.example.cryptomax.ui.nft

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmbeddedSearchBar(
    onQueryChange: Boolean,
    onSearch:(String) -> Unit,
    isSearchActive: Boolean,
    modifier: Modifier = Modifier,
    onActiveChanged:(Boolean) -> Unit
){
    var searchQuery by rememberSaveable { mutableStateOf("") }

    val activeChanged:(Boolean) -> Unit = { active ->
        searchQuery = ""
        onActiveChanged(active)
    }
    SearchBar(modifier = Modifier.padding(start = 12.dp, top = 2.dp, end = 12.dp, bottom = 12.dp)
        .fillMaxWidth(),
        query = searchQuery,
        onQueryChange = {query ->
          searchQuery = query
        },
        onSearch = onSearch,
        active = isSearchActive,
        onActiveChange = activeChanged,
        placeholder = {Text("Search")},
        trailingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        }
            ) {
        
    }

}