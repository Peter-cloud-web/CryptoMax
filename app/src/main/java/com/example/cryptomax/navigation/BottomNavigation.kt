package com.example.cryptomax.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cryptomax.ui.screens.exchanges.screen.ExchangeScreen
import com.example.cryptomax.ui.screens.explore.screen.ExploreScreen
import com.example.cryptomax.ui.screens.news.screen.NewsScreen

@Composable
fun MainScreenView() {
    val navController = rememberNavController()
    BottomNavigation(navController = navController)


}

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavDestinations.HomeScreen,
        BottomNavDestinations.ExchangeScreen,
        BottomNavDestinations.Explore,
        BottomNavDestinations.News
    )

    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { item ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painterResource(id = item.iconUnSelected),
                                contentDescription = item.title
                            )
                        },
                        label = { Text(text = item.title, fontSize = 9.sp) },
                        selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                        onClick = {
                            navController.navigate(item.route) {
                                navController.graph.startDestinationRoute?.let { screen_route ->
                                    popUpTo(screen_route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    )
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    androidx.navigation.compose.NavHost(
        navController,
        startDestination = BottomNavDestinations.HomeScreen.route
    ) {
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


