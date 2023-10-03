package com.example.viewModel.uistates

import com.example.cryptomax.models.coinListModel.CoinResponse
import com.example.cryptomax.models.coinListModel.Data
import com.example.cryptomax.models.coinNews.CoinNewsResponse

data class CoinAssetsUiStates(
    val isLoading: Boolean = false,
    val success: CoinResponse? = null,
    val error: String = ""
)

data class NewsAssetUiState(
    val isLoading: Boolean = false,
    val success: CoinNewsResponse? = null,
    val error: String = ""
)