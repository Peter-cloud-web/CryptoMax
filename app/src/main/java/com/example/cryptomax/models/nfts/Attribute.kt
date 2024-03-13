package com.example.cryptomax.models.nfts

import kotlinx.serialization.Serializable

@Serializable
data class Attribute(
    val trait_type: String,
    val value: String
)