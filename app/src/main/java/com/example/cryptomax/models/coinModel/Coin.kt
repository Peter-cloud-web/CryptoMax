package com.example.cryptomax.models.coinModel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Coin(
    @SerialName("data") val `data`: DataX,
    @SerialName("timestamp") val timestamp: Long
)