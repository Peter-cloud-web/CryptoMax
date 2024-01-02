package com.example.cryptomax.repo

import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.cryptomax.models.candlesModel.Candle
import com.example.cryptomax.models.coinListModel.Coin
import com.example.cryptomax.models.coinMarketsModel.CoinMarketsResponse
import com.example.cryptomax.models.coinModel.CoinDetailsResponse
import com.example.cryptomax.models.coinModel.DataX
import com.example.cryptomax.models.coinNews.CoinNewsResponse
import com.example.cryptomax.resource.Resource
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val coinApi: CoinApi):Repository {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getCoinAssets(): Resource<List<Coin>> {
        return coinApi.getCoinAssets()
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getCoinById(id:String):Resource<CoinDetailsResponse> {
        return coinApi.getCoinById(id)
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getCoinIntervalHistory(id: String): Resource<Candle> {
        return coinApi.getCoinIntervalHistory(id)
    }

    override suspend fun getCoinNews(query: String): Resource<CoinNewsResponse> {
      return coinApi.getCoinNews(query)
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getCoinMarkets(id: String): Resource<CoinMarketsResponse> {
        return coinApi.getCoinMarkets(id)
    }

}