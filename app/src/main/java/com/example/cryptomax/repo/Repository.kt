package com.example.cryptomax.repo

import com.example.cryptomax.models.coinModels.candlesModel.Candle
import com.example.cryptomax.models.coinModels.coinListModel.Coin

import com.example.cryptomax.models.coinModels.coinMarketsModel.CoinMarketsResponse
import com.example.cryptomax.models.coinModels.CoinDetailsResponse
import com.example.cryptomax.models.news.coinNews.CoinNewsResponse
import com.example.cryptomax.models.nfts.Nft
import com.example.cryptomax.models.nfts.NftsResponse
import com.example.cryptomax.resource.Resource

interface Repository {
   suspend fun getCoinAssets(): Resource<List<Coin>>
   suspend fun getCoinById(id:String): Resource<CoinDetailsResponse>
   suspend fun getCoinIntervalHistory(id:String):Resource<Candle>
   suspend fun getCoinNews(query:String):Resource<CoinNewsResponse>
   suspend fun getCoinMarkets(id:String):Resource<CoinMarketsResponse>
   suspend fun getNFTs():Resource<NftsResponse>
}