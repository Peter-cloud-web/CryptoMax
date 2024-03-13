package com.example.cryptomax.models.nfts

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class Nft(
    val animation_url: @Contextual String?,
    val cached_animation_url:  @Contextual String?,
    val cached_file_url: String,
    val chain: String,
    val contract_address: String,
    val creator_address: String,
    val file_url: String,
    val metadata: MetadataX,
    val metadata_url: String,
    val owner: String,
    val token_id: String,
    val updated_date: String
)
