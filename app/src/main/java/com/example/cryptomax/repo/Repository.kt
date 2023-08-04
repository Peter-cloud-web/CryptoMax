package com.example.cryptomax.repo

import com.example.cryptomax.models.CoinResponse
import com.example.cryptomax.resource.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {
   suspend fun getCoinAssets(): Resource<CoinResponse>
}