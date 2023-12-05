package com.example.cryptomax.repo

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.cryptomax.BuildConfig
import com.example.cryptomax.common.util.Consts.ASSETS
import com.example.cryptomax.common.util.Consts.COINCAP_API
import com.example.cryptomax.common.util.Consts.NEWS_API
import com.example.cryptomax.dtoModel.CoinDto
import com.example.cryptomax.dtoModel.CoinResponseDto
import com.example.cryptomax.dtoModel.mapper.Mappers
import com.example.cryptomax.dtoModel.mapper.Mappers.toCoin
import com.example.cryptomax.models.candlesModel.Candle
import com.example.cryptomax.models.coinListModel.Coin
import com.example.cryptomax.models.coinMarketsModel.CoinMarketsResponse
import com.example.cryptomax.models.coinModel.DataX
import com.example.cryptomax.models.coinNews.CoinNewsResponse
import com.example.cryptomax.resource.Resource
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import java.io.IOException
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val httpClient:HttpClient):Repository {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getCoinAssets(): Resource<List<Coin>> {
        return try{
            Resource.Loading(null)
            val response = httpClient.get<CoinResponseDto>{
                url{
                    protocol = URLProtocol.HTTPS
                    host = COINCAP_API
                    encodedPath = ASSETS
                }
            }
            val coins = response.coins.map { coinDto ->
               coinDto.toCoin(coinDto)
            }
            Resource.Success(coins)

        }catch (e:Exception){
            Resource.Error(e.localizedMessage?:"An unexpected error occurred")
        }catch (e:IOException){
            Resource.Error(e.localizedMessage?:"Network server error")
        }catch (e: HttpException){
            Resource.Error(e.localizedMessage?:"Network error")
        }


    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getCoinById(id:String):Resource<DataX> {
        return try {
            Resource.Loading(null)
            val coin = httpClient.get<DataX> {
                url {
                    protocol = URLProtocol.HTTPS
                    host = COINCAP_API
                    encodedPath = ASSETS + "/$id"
                }
            }
                Resource.Success(coin)
        }catch (e:Exception){
            Resource.Error(e.localizedMessage?:"An unexpected error occurred")
        }catch (e:IOException){
            Resource.Error(e.localizedMessage?:"Network server error")
        }catch (e: HttpException){
            Resource.Error(e.localizedMessage?:"Network error")
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getCoinIntervalHistory(id: String): Resource<Candle> {
        return try {
            Resource.Loading(null)
            val candle = httpClient.get<Candle>{
                url {
                    protocol = URLProtocol.HTTPS
                    host = COINCAP_API
                    encodedPath = ASSETS + "/$id" + "/history?interval=d1"
                }
            }
            Resource.Success(candle)
        }catch (e:Exception){
            Resource.Error(e.localizedMessage?:"An unexpected error occurred")
        }catch (e:IOException){
            Resource.Error(e.localizedMessage?:"Network server error")
        }catch (e: HttpException){
            Resource.Error(e.localizedMessage?:"Network error")
        }
    }

    override suspend fun getCoinNews(query: String): Resource<CoinNewsResponse> {
        return try{
            Resource.Loading(null)
            val coinNews = httpClient.get<CoinNewsResponse>{
                url{
                    protocol = URLProtocol.HTTPS
                    host = NEWS_API
                    encodedPath = "/v2/everything"
                    parameters.append("q", query)
                    parameters.append("apikey", BuildConfig.NEWS_API_KEY)
                }
            }
            Resource.Success(coinNews)
        } catch (e: Exception) {
            Resource.Error(
                e.localizedMessage ?: " An unexpected error. Try again later."
            )
        } catch (e: IOException) {
            Resource.Error(
                e.localizedMessage ?: "Network/Server error. Check internet connection"
            )
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getCoinMarkets(id: String): Resource<CoinMarketsResponse> {
        return try{
            Resource.Loading(null)
            val response = httpClient.get<CoinMarketsResponse>{
                url{
                    protocol = URLProtocol.HTTPS
                    host = COINCAP_API
                    encodedPath = ASSETS + "/$id" + "/markets"
                }
            }
            Resource.Success(response)

        }catch (e:Exception){
            Resource.Error(e.localizedMessage?:"An unexpected error occurred")
        }catch (e:IOException){
            Resource.Error(e.localizedMessage?:"Network server error")
        }catch (e: HttpException){
            Resource.Error(e.localizedMessage?:"Network error")
        }
    }
}