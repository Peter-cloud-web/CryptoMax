package com.example.cryptomax.models.candlesModel

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val priceUsd: String,
    val time: Long
)