package com.example.cryptomax.repo

import com.example.cryptomax.models.candlesModel.Candle
import com.example.cryptomax.models.coinModel.Coin
import com.example.cryptomax.models.coinListModel.CoinResponse
import com.example.cryptomax.models.coinNews.CoinNewsResponse
import com.example.cryptomax.resource.Resource

interface Repository {
   suspend fun getCoinAssets(): Resource<CoinResponse>
   suspend fun getCoinById(id:String): Resource<Coin>
   suspend fun getCoinIntervalHistory(id:String):Resource<Candle>
   suspend fun getCoinNews(query:String):Resource<CoinNewsResponse>
}