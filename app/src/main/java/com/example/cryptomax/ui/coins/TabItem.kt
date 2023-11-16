package com.example.cryptomax.ui.coins

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.Composable
import com.example.cryptomax.R
import com.example.cryptomax.ui.screens.detail.screen.CoinDetailScreen

sealed class TabItem(var icon:Int,var title:String,var Screen:@Composable () -> Unit){
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    @RequiresApi(Build.VERSION_CODES.O)
    object DetailsScreen:TabItem(R.drawable.baseline_currency_bitcoin_24, "Assets",{ CoinDetailScreen()})
    object Rates:TabItem(R.drawable.rates,"Rates",{ RatesScreen()})
    object Markets:TabItem(R.drawable.market,"Markets",{ MarketsScreen()})
}