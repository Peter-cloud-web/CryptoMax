package com.example.cryptomax.dtoModel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinResponseDto(
    @SerialName("data") val coins : List<CoinDto>,
    @SerialName("timestamp") val timestamp: Long
)