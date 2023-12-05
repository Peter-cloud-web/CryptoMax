package com.example.cryptomax.models.coinMarketsModel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinMarketsResponse(
    @SerialName("data") val markets: List<Data>,
    @SerialName("timestamp") val timestamp: Long
)