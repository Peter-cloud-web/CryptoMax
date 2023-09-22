package com.example.cryptomax

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptomax.ui.screens.detail.screen.CoinDetailScreen
import com.example.cryptomax.ui.screens.home.screen.HomeScreen
import com.example.cryptomax.ui.theme.CryptoMaxTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoMaxTheme {
                CryptoApp()
            }
        }
    }

    @Composable
    private fun CryptoApp() {
        val navController = rememberNavController()
        NavHost(navController, startDestination = "homescreen") {
            composable(route = "homescreen") {
                HomeScreen(navController, onItemClick = { coinId ->
                    navController.navigate("detailsScreen/$coinId")
                })
            }
            composable(route = "detailsScreen/{coinId}") { backStackEntry ->
                val coinId = backStackEntry.arguments?.getString("coinId")
                requireNotNull(coinId) { "CoinId wasn't found. Please make sure its set!" }
                CoinDetailScreen()
            }

        }
    }
}