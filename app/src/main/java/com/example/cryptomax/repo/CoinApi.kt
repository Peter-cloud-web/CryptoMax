package com.example.cryptomax.repo

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.cryptomax.BuildConfig
import com.example.cryptomax.common.util.Consts
import com.example.cryptomax.dtoModel.CoinResponseDto
import com.example.cryptomax.dtoModel.mapper.Mappers.toCoin
import com.example.cryptomax.models.coinModels.CoinDetailsResponse
import com.example.cryptomax.models.coinModels.candlesModel.Candle
import com.example.cryptomax.models.coinModels.coinListModel.Coin
import com.example.cryptomax.models.coinModels.coinMarketsModel.CoinMarketsResponse
import com.example.cryptomax.models.news.coinNews.CoinNewsResponse
import com.example.cryptomax.models.nfts.NftsResponse
import com.example.cryptomax.resource.Resource
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import java.io.IOException
import javax.inject.Inject

class CoinApi @Inject constructor(private val httpClient: HttpClient) {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    suspend fun getCoinAssets(): Resource<List<Coin>> {

        return try {
            Resource.Loading(null)
            val response = httpClient.get<CoinResponseDto> {
                url {
                    protocol = URLProtocol.HTTPS
                    host = Consts.COINCAP_API
                    encodedPath = Consts.ASSETS
                }
            }
            val coins = response.coins.map { coinDto ->
                coinDto.toCoin(coinDto)
            }
            Resource.Success(coins)

        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            Resource.Error(e.localizedMessage ?: "Network server error")
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "Network error")
        }

    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    suspend fun getCoinById(id: String): Resource<CoinDetailsResponse> {
        return try {
            Resource.Loading(null)
            val coin = httpClient.get<CoinDetailsResponse> {
                url {
                    protocol = URLProtocol.HTTPS
                    host = Consts.COINCAP_API
                    encodedPath = Consts.ASSETS + "/$id"
                }
            }
            Resource.Success(coin)
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            Resource.Error(e.localizedMessage ?: "Network server error")
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "Network error")
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    suspend fun getCoinIntervalHistory(id: String): Resource<Candle> {

        return try {
            Resource.Loading(null)
            val candle = httpClient.get<Candle> {
                url {
                    protocol = URLProtocol.HTTPS
                    host = Consts.COINCAP_API
                    encodedPath = Consts.ASSETS + "/$id" + "/history?interval=d1"
                }
            }
            Resource.Success(candle)
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            Resource.Error(e.localizedMessage ?: "Network server error")
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "Network error")
        }

    }

    suspend fun getCoinNews(query: String): Resource<CoinNewsResponse> {

        return try {
            Resource.Loading(null)
            val coinNews = httpClient.get<CoinNewsResponse> {
                url {
                    protocol = URLProtocol.HTTPS
                    host = Consts.NEWS_API
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
    suspend fun getCoinMarkets(id: String): Resource<CoinMarketsResponse> {
        return try {
            Resource.Loading(null)
            val response = httpClient.get<CoinMarketsResponse> {
                url {
                    protocol = URLProtocol.HTTPS
                    host = Consts.COINCAP_API
                    encodedPath = Consts.ASSETS + "/$id" + "/markets"
                }
            }
            Resource.Success(response)

        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            Resource.Error(e.localizedMessage ?: "Network server error")
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "Network error")
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    suspend fun getNFTs(): Resource<NftsResponse> {

        return try {
            Resource.Loading(null)
            val response = httpClient.get<NftsResponse> {

                url {
                    protocol = URLProtocol.HTTPS
                    host = Consts.NFT_API
                    encodedPath = Consts.CONTRACT_NFTS
                    parameters.append("chain", "ethereum")
                    parameters.append("page_number", "1")
                    parameters.append("page_size", "50")
                    parameters.append("include", "metadata")
                    parameters.append("refresh_metadata", "false")

                    header("Authorization", "a0abfb4b-a1ff-4acb-a268-44c9a7e927f0")
                    header("Accept", ContentType.Application.Json.toString())
                }
            }
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            Resource.Error(e.localizedMessage ?: "Network server error")
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "Network error")
        }
    }
}
