package com.example.cryptomax.models.nfts

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class Metadata(
    val banner_url: String,
    val cached_banner_url:  @Contextual String?,
    val cached_thumbnail_url:  @Contextual String?,
    val description: String,
    val thumbnail_url: String
)