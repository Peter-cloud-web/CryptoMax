package com.example.cryptomax.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptomax.ui.screens.detail.screen.CoinDetailScreen
import com.example.cryptomax.ui.screens.exchanges.screen.ExchangeScreen
import com.example.cryptomax.ui.screens.explore.screen.ExploreScreen
import com.example.cryptomax.ui.screens.home.screen.HomeScreen
import com.example.cryptomax.ui.screens.news.screen.NewsScreen

@RequiresApi(Build.VERSION_CODES.O)
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun MainScreenView() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                appDestinations = BottomNavDestinations.toList
            )
        },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                NavigationGraph(navController = navController)
            }
        }
    )


}


@Composable
fun BottomNavigationBar(
    navController: NavController,
    appDestinations: List<BottomNavDestinations>
) {
    BottomNavigation(
        backgroundColor = Color.Blue, contentColor = Color.White
    ) {


    }
}

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationGraph(navController: NavHostController) {
    androidx.navigation.compose.NavHost(navController,
        startDestination = BottomNavDestinations.HomeScreen.route
    ) {
        composable(route = "home_screen") {
            HomeScreen(navController, onItemClick = { coinId ->
                navController.navigate("detailsScreen/$coinId")
            })
        }
        composable(route = "detailsScreen/{coinId}") { backStackEntry ->
            val coinId = backStackEntry.arguments?.getString("coinId")
            requireNotNull(coinId) { "CoinId wasn't found. Please make sure its set!" }
            CoinDetailScreen()
        }
        composable(route = BottomNavDestinations.Explore.route) { backStackEntry ->
            ExploreScreen(navController = navController)
        }
        composable(route = BottomNavDestinations.ExchangeScreen.route) { backStackEntry ->
            ExchangeScreen(navController = navController)
        }
        composable(route = BottomNavDestinations.News.route) { backStackEntry ->
            NewsScreen(navController = navController)
        }
    }
}


