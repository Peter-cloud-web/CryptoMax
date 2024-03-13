package com.example.cryptomax.models.news.coinNews

import kotlinx.serialization.Serializable

@Serializable
data class Source(
    val id: String?,
    val name: String?
)