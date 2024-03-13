package com.example.cryptomax.models.coinModels.coinMarketsModel

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val baseId: String,
    val baseSymbol: String,
    val exchangeId: String,
    val priceUsd: String,
    val quoteId: String,
    val quoteSymbol: String,
    val volumePercent: String,
    val volumeUsd24Hr: String
)