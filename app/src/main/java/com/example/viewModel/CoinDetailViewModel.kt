package com.example.viewModel

import android.net.http.HttpException
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptomax.models.candlesModel.Data
import com.example.cryptomax.models.coinListModel.Coin
import com.example.cryptomax.models.coinModel.DataX
import com.example.cryptomax.repo.Repository
import com.example.cryptomax.resource.Resource
import com.example.viewModel.uistates.CoinDetailsUiState
import com.example.viewModel.uistates.MarketsUiState
import com.example.viewModel.uistates.NewsAssetUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val repository: Repository,
    private val stateHandle: SavedStateHandle
) : ViewModel() {

    val state = MutableStateFlow(CoinDetailsUiState())
    val coinDetails = state.asStateFlow()

    val listState = mutableStateOf<List<Data>?>(null)

    private val allNews = MutableStateFlow(NewsAssetUiState())
    val allArticles = allNews.asStateFlow()

    private val allMarkets = MutableStateFlow(MarketsUiState())
    val _allMarkets = allMarkets.asStateFlow()


    val id = stateHandle.get<String>("coinId") ?: null


    init {
        if (id != null) {
            getCoin(id)
            getCandleData(id)
            getCoinMarkets(id)
            getCoinNews(id)
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getCoin(id: String) {
        state.value = CoinDetailsUiState(isLoading = true)
        viewModelScope.launch {
            val coin = repository.getCoinById(id)
            Log.d("COINDETAILVIEWMODEL","${coin.data}")
            Log.d("COINDETAILVIEWMODEL","${id}")
            state.value = CoinDetailsUiState(success = coin.data)
        }
        state.value = CoinDetailsUiState(error = "Unexpected error occured")
    }

    fun getCandleData(id: String) {
        viewModelScope.launch {
            val data = repository.getCoinIntervalHistory(id)
            listState.value = data.data?.data
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getCoinNews(id: String) {
        try {
            allNews.value = NewsAssetUiState(isLoading = true)
            viewModelScope.launch {
                val news = repository.getCoinNews(id)
                allNews.value = when (news) {
                    is Resource.Success -> NewsAssetUiState(success = news.data)
                    is Resource.Error -> news.message?.let { NewsAssetUiState(error = it) }!!
                    is Resource.Loading -> NewsAssetUiState(isLoading = true)
                }
            }
        } catch (e: Exception) {
            allNews.value =
                NewsAssetUiState(error = e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: HttpException) {
            allNews.value =
                NewsAssetUiState(error = e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            allNews.value =
                NewsAssetUiState(error = e.localizedMessage ?: "An unexpected error occurred")
        }

    }

    fun getCoinMarkets(id: String) {
        try {
            allMarkets.value = MarketsUiState(isLoading = true)
            viewModelScope.launch {
                val markets = repository.getCoinMarkets(id)
                allMarkets.value = when (markets) {
                    is Resource.Loading -> MarketsUiState(isLoading = true)
                    is Resource.Success -> MarketsUiState(success = markets.data)
                    is Resource.Error -> markets.message?.let { MarketsUiState(error = it) }!!
                }
            }
        } catch (e: HttpException) {
            allMarkets.value =
                MarketsUiState(error = e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            allMarkets.value =
                MarketsUiState(error = e.localizedMessage ?: "An unexpected error occurred")
        }

    }
}
