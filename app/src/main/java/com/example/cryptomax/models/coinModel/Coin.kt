package com.example.cryptomax.models.coinModel

import kotlinx.serialization.Serializable

@Serializable
data class Coin(
    val `data`: DataX,
    val timestamp: Long
)