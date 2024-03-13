package com.example.cryptomax.models.nfts

import kotlinx.serialization.Serializable

@Serializable
data class NftsResponse(
    val contract: Contract,
    val nfts: List<Nft>,
    val response: String,
    val total: Int
)