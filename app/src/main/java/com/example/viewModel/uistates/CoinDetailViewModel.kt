package com.example.viewModel.uistates

import android.net.http.HttpException
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptomax.models.candlesModel.Candle
import com.example.cryptomax.models.candlesModel.Data
import com.example.cryptomax.models.coinModel.Coin
import com.example.cryptomax.models.coinNews.Article
import com.example.cryptomax.repo.Repository
import com.example.cryptomax.resource.Resource
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

    val state = mutableStateOf<Coin?>(null)
    val listState = mutableStateOf<List<Data>?>(null)

    private val allNews = MutableStateFlow(NewsAssetUiState())
    val allArticles = allNews.asStateFlow()


    val id = stateHandle.get<String>("coinId") ?: null


    init {
        if (id != null) {
            getCoin(id)
            getCandleData(id)
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getCoin(id: String) {
        viewModelScope.launch {
            val coin = repository.getCoinById(id)
            state.value = coin.data
            getCoinNews(id)
        }
    }

    fun getCandleData(id : String){
        viewModelScope.launch {
            val data = repository.getCoinIntervalHistory(id)
            listState.value = data.data?.data
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getCoinNews(id: String){
        try{
            allNews.value = NewsAssetUiState(isLoading = true)
            viewModelScope.launch{
                val news = repository.getCoinNews(id)
                allNews.value = when(news){
                    is Resource.Success -> NewsAssetUiState(success = news.data)
                    is Resource.Error -> news.message?.let { NewsAssetUiState(error = it) }!!
                    is Resource.Loading -> NewsAssetUiState(isLoading = true)
                }
            }
        }catch (e:Exception){
        allNews.value =
            NewsAssetUiState(error = e.localizedMessage ?: "An unexpected error occurred")
    }catch (e: HttpException){
            allNews.value =
                NewsAssetUiState(error = e.localizedMessage ?: "An unexpected error occurred")
    }catch (e:IOException){
            allNews.value =
                NewsAssetUiState(error = e.localizedMessage ?: "An unexpected error occurred")
    }

    }

}