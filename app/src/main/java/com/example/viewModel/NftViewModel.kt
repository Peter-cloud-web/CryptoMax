package com.example.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.example.cryptomax.repo.Repository
import com.example.cryptomax.resource.Resource
import com.example.viewModel.uistates.NFTsUiStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel()
class NftViewModel @Inject constructor(private val repository: Repository): ViewModel(){
    private val _allNFTs = MutableStateFlow(NFTsUiStates())
    val allNFTs = _allNFTs.asStateFlow()

    init {
        getNFTs()
    }

    fun getNFTs(){
        try{
            viewModelScope.launch {
                _allNFTs.value = NFTsUiStates(isLoading = true)
                val data = repository.getNFTs()
                Log.d("ALL NFTS","${data.toString()}")
                _allNFTs.value = when(data){
                    is Resource.Success -> NFTsUiStates(success = data.data)
                    is Resource.Error -> data.message?.let { message -> NFTsUiStates(error = message) }!!
                    is Resource.Loading -> NFTsUiStates(isLoading = true)
                }
            }
        } catch (e:Exception){
            _allNFTs.value =
                NFTsUiStates(error = e.localizedMessage ?: "An unexpected error occurred")
        }catch (e: HttpException){
            _allNFTs.value =
                NFTsUiStates(error = e.localizedMessage ?: "An unexpected error occurred")
        }catch (e: IOException){
            _allNFTs.value =
                NFTsUiStates(error = e.localizedMessage ?: "An unexpected error occurred")
        }


    }

}