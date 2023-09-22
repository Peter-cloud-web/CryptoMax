package com.example.cryptomax.repo

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.cryptomax.common.util.Consts.ASSETS
import com.example.cryptomax.common.util.Consts.COINCAP_API
import com.example.cryptomax.models.candlesModel.Candle
import com.example.cryptomax.models.coinModel.Coin
import com.example.cryptomax.models.coinListModel.CoinResponse
import com.example.cryptomax.resource.Resource
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import java.io.IOException
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val httpClient:HttpClient):Repository {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getCoinAssets(): Resource<CoinResponse> {
        return try{
            Resource.Loading(null)
            val response = httpClient.get<CoinResponse>{
                url{
                    protocol = URLProtocol.HTTPS
                    host = COINCAP_API
                    encodedPath = ASSETS
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

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getCoinById(id:String):Resource<Coin> {
        return try {
            Resource.Loading(null)
            val coin = httpClient.get<Coin> {
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
                    encodedPath = ASSETS + "/$id"
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
}