package com.example.cryptomax.ui.screens.detail.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cryptomax.models.coinNews.Article
import com.example.cryptomax.ui.coins.CoinDetail
import com.example.cryptomax.ui.coins.NewsItem
import com.example.cryptomax.ui.component.homeScreenComponents.ProgressBar
import com.example.cryptomax.ui.screens.home.screen.CoinList
import com.example.viewModel.uistates.CoinDetailViewModel

@RequiresApi(Build.VERSION_CODES.O)
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun CoinDetailScreen(){
CoinDetail()
}