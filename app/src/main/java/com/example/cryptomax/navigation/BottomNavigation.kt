package com.example.cryptomax.navigation


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptomax.ui.coins.MainScreen
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

    val screens = listOf(
        BottomNavDestinations.HomeScreen,
        BottomNavDestinations.ExchangeScreen,
        BottomNavDestinations.Explore,
        BottomNavDestinations.News
    )

    var selectedScreen by remember { mutableStateOf(screens.first()) }
    Scaffold(
        bottomBar = {
            BottomNavigation(backgroundColor = Color.Black, contentColor = Color.White) {
                screens.forEach { screen ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = screen.icon),
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(
                                text = screen.title,
                                style = MaterialTheme.typography.labelSmall,
                                color = if (screen == selectedScreen) Color.White else Color.Gray
                            )
                        },
                        selected = screen == selectedScreen,
                        onClick = {
                            selectedScreen = screen
                            navController.navigate(screen.route)
                        },
                        modifier = Modifier.padding(8.dp)
                    )
                }

            }
        },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                NavigationGraph(navController = navController)
            }
        }
    )
}


@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationGraph(navController: NavHostController) {
    androidx.navigation.compose.NavHost(
        navController,
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
            MainScreen()
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



