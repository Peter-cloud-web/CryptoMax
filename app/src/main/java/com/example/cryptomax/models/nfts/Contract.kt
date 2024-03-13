package com.example.cryptomax.models.nfts

import kotlinx.serialization.Serializable

@Serializable
data class Contract(
    val metadata: Metadata,
    val name: String,
    val symbol: String,
    val type: String
)