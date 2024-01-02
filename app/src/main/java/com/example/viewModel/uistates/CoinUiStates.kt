package com.example.viewModel.uistates

import com.example.cryptomax.models.coinListModel.Coin
import com.example.cryptomax.models.coinListModel.CoinResponse
import com.example.cryptomax.models.coinMarketsModel.CoinMarketsResponse
import com.example.cryptomax.models.coinModel.CoinDetailsResponse
import com.example.cryptomax.models.coinModel.DataX
import com.example.cryptomax.models.coinNews.CoinNewsResponse

data class CoinAssetsUiStates(
    val isLoading: Boolean = false,
    val success: List<Coin>? = null,
    val error: String = ""
)

data class NewsAssetUiState(
    val isLoading: Boolean = false,
    val success: CoinNewsResponse? = null,
    val error: String = ""
)

data class MarketsUiState(
    val isLoading: Boolean = false,
    val success: CoinMarketsResponse? = null,
    val error: String = ""
)

data class CoinDetailsUiState(
    val isLoading: Boolean = false,
    val success: CoinDetailsResponse? = null,
    val error: String = ""
)