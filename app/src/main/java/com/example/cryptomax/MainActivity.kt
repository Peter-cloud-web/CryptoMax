package com.example.cryptomax

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cryptomax.models.Data
import com.example.cryptomax.ui.coins.CoinItem
import com.example.cryptomax.ui.theme.CryptoMaxTheme
import com.example.viewModel.CoinViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val coinViewModel: CoinViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoMaxTheme {
                val allAssetsState = coinViewModel.allAssets.collectAsState()
                allAssetsState.value.let { states ->
                    when {
                        states.isLoading -> {
                            // Display loading UI here if needed
                        }

                        states.success != null -> {
                            CoinList(coins = states.success.coins)
                        }

                        states.error != null -> {
                            // Display error UI here if needed
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun CoinList(coins: List<Data>, modifier: Modifier = Modifier) {
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
