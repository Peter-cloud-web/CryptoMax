package com.example.cryptomax.models.candlesModel

import kotlinx.serialization.Serializable

@Serializable
data class Candle(
    val `data`: List<Data>,
    val timestamp: Long
)