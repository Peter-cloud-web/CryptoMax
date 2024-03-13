package com.example.cryptomax.models.nfts

import kotlinx.serialization.Serializable

@Serializable
data class MetadataX(
    val attributes: List<Attribute>,
    val image: String
)