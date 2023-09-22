package com.example.viewModel.uistates

import com.example.cryptomax.models.coinListModel.CoinResponse
import com.example.cryptomax.models.coinListModel.Data

data class CoinAssetsUiStates(
    val isLoading: Boolean = false,
    val success: CoinResponse? = null,
    val error: String = ""
)

data class CoinAssetUiState(
    val isLoading: Boolean = false,
    val success: Data? = null,
    val error: String = ""
)