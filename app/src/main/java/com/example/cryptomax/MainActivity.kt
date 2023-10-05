package com.example.cryptomax

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptomax.navigation.BottomNavDestinations
import com.example.cryptomax.navigation.MainScreenView
import com.example.cryptomax.ui.screens.detail.screen.CoinDetailScreen
import com.example.cryptomax.ui.screens.exchanges.screen.ExchangeScreen
import com.example.cryptomax.ui.screens.explore.screen.ExploreScreen
import com.example.cryptomax.ui.screens.home.screen.HomeScreen
import com.example.cryptomax.ui.screens.news.screen.NewsScreen
import com.example.cryptomax.ui.theme.CryptoMaxTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoMaxTheme {
                CryptoApp()
                MainScreenView()
            }
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    @RequiresApi(Build.VERSION_CODES.O)
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