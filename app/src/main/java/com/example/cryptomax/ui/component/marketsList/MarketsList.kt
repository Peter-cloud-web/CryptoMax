package com.example.cryptomax.ui.component.marketsList

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cryptomax.models.coinModels.coinMarketsModel.Data
import com.example.cryptomax.ui.coins.MarketsItem
import com.example.cryptomax.ui.component.homeScreenComponents.ProgressBar
import com.example.viewModel.CoinDetailViewModel

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun MarketsList(){
    val viewModel:CoinDetailViewModel = hiltViewModel()
    val marketsStates = viewModel._allMarkets.collectAsState()
    marketsStates.value.let { state ->
        when{
            state.isLoading -> {
                ProgressBar()
            }
            state.success != null -> {
                state.success.markets.let { marketsList ->
                    MarketsListItem(markets = marketsList)
                }
            }
            state.error != null -> "An unexpected error occurred"

            else -> {}
        }

    }
}
@Composable
fun MarketsListItem(markets: List<Data>) {
//    Text(
//        modifier = Modifier.padding(12.dp),
//        text = "COIN MARKETS",
//        style = MaterialTheme.typography.titleLarge,
//        fontWeight = FontWeight.Bold
//    )
    LazyColumn(contentPadding = PaddingValues(5.dp)) {
        items(markets) { market ->
            MarketsItem(market)
        }
    }
}