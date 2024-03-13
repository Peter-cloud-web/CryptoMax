package com.example.viewModel.uistates

import com.example.cryptomax.models.coinModels.coinListModel.Coin
import com.example.cryptomax.models.coinModels.coinMarketsModel.CoinMarketsResponse
import com.example.cryptomax.models.coinModels.CoinDetailsResponse
import com.example.cryptomax.models.news.coinNews.CoinNewsResponse
import com.example.cryptomax.models.nfts.Nft
import com.example.cryptomax.models.nfts.NftsResponse

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
data class NFTsUiStates(
    val isLoading: Boolean = false,
    val success: NftsResponse? = null,
    val error: String = ""
)