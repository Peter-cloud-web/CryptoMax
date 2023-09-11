package com.example.cryptomax.ui.screens.home.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.cryptomax.models.Data
import com.example.cryptomax.ui.coins.CoinItem
import com.example.cryptomax.ui.component.Header
import com.example.cryptomax.ui.component.ProgressBar
import com.example.viewModel.CoinViewModel

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    val coinViewModel: CoinViewModel = viewModel()
    val allAssetsState = coinViewModel.allAssets.collectAsState()
    allAssetsState.value.let { states ->
        when {
            states.isLoading -> {
                ProgressBar()
            }

            states.success != null -> {
                CoinList(coins = states.success.coins)
            }

            states.error != null -> "An unexpected error occurred"

            else -> {}
        }
    }

}

@Composable
internal fun CoinList(coins: List<Data>, modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Header()

        Text(
            text = "Assets",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)

        )
        LazyColumn(
            modifier = modifier,
            contentPadding = PaddingValues(16.dp)
        ) {
            items(coins) { item ->
                CoinItem(coin = item)
            }
        }
    }
}


