package com.example.cryptomax.models.news.coinNews

import kotlinx.serialization.Serializable

@Serializable
data class CoinNewsResponse(
    val articles: List<Article>?,
    val status: String,
    val totalResults: Int
)