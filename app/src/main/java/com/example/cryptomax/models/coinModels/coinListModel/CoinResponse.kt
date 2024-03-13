package com.example.cryptomax.models.coinModels.coinListModel

data class CoinResponse(
    val coins: List<Coin>,
    val timestamp: Long
)