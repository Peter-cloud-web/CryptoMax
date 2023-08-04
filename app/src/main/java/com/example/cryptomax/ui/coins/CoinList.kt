package com.example.cryptomax.ui.coins

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.cryptomax.models.Data

@Composable
fun CoinList(coins:List<Data>){
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn {
            items(coins) {
                CoinItem(it)
            }
        }
    }
}
