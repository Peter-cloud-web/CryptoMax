package com.example.cryptomax.models.coinListModel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CoinResponse(
    @SerialName("data") val coins : List<Data>,
    @SerialName("timestamp")val timestamp: Long
)