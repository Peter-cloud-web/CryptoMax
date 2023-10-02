package com.example.viewModel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.example.cryptomax.repo.Repository
import com.example.cryptomax.resource.Resource
import com.example.viewModel.uistates.CoinAssetsUiStates
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(private val repository: Repository,private val stateHandle: SavedStateHandle) : ViewModel() {
    private val _allCoins = MutableStateFlow(CoinAssetsUiStates())
    val allAssets = _allCoins.asStateFlow()

    init {

        getCoins()
        getCoinNews()
    }
    fun getCoins(){
        try{
            viewModelScope.launch {
                _allCoins.value = CoinAssetsUiStates(isLoading = true)
                val data = repository.getCoinAssets()
                _allCoins.value = when(data){
                    is Resource.Success -> CoinAssetsUiStates(success = data.data)
                    is Resource.Error -> data.message?.let { CoinAssetsUiStates(error = it) }!!
                    is Resource.Loading -> CoinAssetsUiStates(isLoading = true)

                }
            }
        }catch (e:Exception){
            _allCoins.value =
                CoinAssetsUiStates(error = e.localizedMessage ?: "An unexpected error occurred")
        }catch (e:HttpException){
            _allCoins.value =
                CoinAssetsUiStates(error = e.localizedMessage ?: "An unexpected error occurred")
        }catch (e:IOException){
            _allCoins.value =
                CoinAssetsUiStates(error = e.localizedMessage ?: "An unexpected error occurred")
        }


    }

    fun getCoinNews(){
        viewModelScope.launch {
            val news = repository.getCoinNews("Bitcoin")
            Log.d("NEWS", "${news.data?.articles}")
        }
    }
}