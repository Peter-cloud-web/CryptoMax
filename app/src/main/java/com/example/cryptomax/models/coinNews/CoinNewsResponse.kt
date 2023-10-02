package com.example.cryptomax.models.coinNews

data class CoinNewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)