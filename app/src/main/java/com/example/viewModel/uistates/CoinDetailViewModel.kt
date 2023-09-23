package com.example.viewModel.uistates

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptomax.models.candlesModel.Candle
import com.example.cryptomax.models.candlesModel.Data
import com.example.cryptomax.models.coinModel.Coin
import com.example.cryptomax.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val repository: Repository,
    private val stateHandle: SavedStateHandle
) : ViewModel() {

    val state = mutableStateOf<Coin?>(null)

    val listState = mutableStateOf<List<Data>?>(null)

    val id = stateHandle.get<String>("coinId") ?: null


    init {
        if (id != null) {
            getCoin(id)
            getCandleData(id)
        }
    }

    fun getCoin(id: String) {
        viewModelScope.launch {
            val coin = repository.getCoinById(id)
            state.value = coin.data
        }
    }

    fun getCandleData(id : String){
        viewModelScope.launch {
            val data = repository.getCoinIntervalHistory(id)
            listState.value = data.data?.data
        }
    }

}