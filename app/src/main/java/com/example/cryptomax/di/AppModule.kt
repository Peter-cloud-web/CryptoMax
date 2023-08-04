package com.example.cryptomax.di

import android.content.Context
import coil.ImageLoader
import com.example.cryptomax.network.CoinCapKtorClient
import com.example.cryptomax.repo.Repository
import com.example.cryptomax.repo.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCoilImageLoader(@ApplicationContext context: Context):ImageLoader{
        return ImageLoader.Builder(context)
            .build()
    }

    @Provides
    @Singleton
    fun getHttpClient():HttpClient{
        return CoinCapKtorClient().getHttpClient()
    }

    @Provides
    @Singleton
    fun provideCoinRepository(httpClient: HttpClient):Repository{
        return RepositoryImpl(httpClient)
    }
}