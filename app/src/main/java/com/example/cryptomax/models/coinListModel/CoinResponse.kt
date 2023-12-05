package com.example.cryptomax.models.coinListModel

data class CoinResponse(
    val coins: List<Coin>,
    val timestamp: Long
)