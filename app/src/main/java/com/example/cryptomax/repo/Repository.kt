package com.example.cryptomax.repo

import com.example.cryptomax.models.candlesModel.Candle
import com.example.cryptomax.models.coinListModel.Coin

import com.example.cryptomax.models.coinMarketsModel.CoinMarketsResponse
import com.example.cryptomax.models.coinModel.CoinDetailsResponse
import com.example.cryptomax.models.coinModel.DataX
import com.example.cryptomax.models.coinNews.CoinNewsResponse
import com.example.cryptomax.resource.Resource

interface Repository {
   suspend fun getCoinAssets(): Resource<List<Coin>>
   suspend fun getCoinById(id:String): Resource<CoinDetailsResponse>
   suspend fun getCoinIntervalHistory(id:String):Resource<Candle>
   suspend fun getCoinNews(query:String):Resource<CoinNewsResponse>
   suspend fun getCoinMarkets(id:String):Resource<CoinMarketsResponse>
}