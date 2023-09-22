package com.example.cryptomax.di

import com.example.cryptomax.repo.Repository
import com.example.viewModel.CoinViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ActivityComponent::class)
object ViewModelProvider {

//    @Provides
//    @ViewModelScoped
//    fun provideCoinViewModel(repository: Repository):CoinViewModel{
//        return CoinViewModel(repository)
//    }
}
