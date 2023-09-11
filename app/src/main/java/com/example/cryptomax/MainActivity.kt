package com.example.cryptomax

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.cryptomax.ui.screens.home.screen.HomeScreen
import com.example.cryptomax.ui.theme.CryptoMaxTheme
import com.example.viewModel.CoinViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val coinViewModel: CoinViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoMaxTheme {
                HomeScreen()
            }
        }
    }
}