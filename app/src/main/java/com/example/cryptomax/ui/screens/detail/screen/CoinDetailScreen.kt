package com.example.cryptomax.ui.screens.detail.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.Composable
import com.example.cryptomax.ui.coins.CoinDetail

@RequiresApi(Build.VERSION_CODES.O)
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun CoinDetailScreen(){
CoinDetail()
}