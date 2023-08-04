package com.example.viewModel.uistates

import com.example.cryptomax.models.CoinResponse
import com.example.cryptomax.resource.Resource

data class CoinAssetsUiStates(
    val isLoading: Boolean = false,
    val success: CoinResponse? = null,
    val error: String = ""
)