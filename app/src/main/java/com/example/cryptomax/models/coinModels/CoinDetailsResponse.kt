package com.example.cryptomax.models.coinModels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinDetailsResponse(
    @SerialName("data") val `data`: Data?,
    @SerialName("timestamp") val timestamp: Long?
)