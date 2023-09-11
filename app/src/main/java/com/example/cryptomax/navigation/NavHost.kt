package com.example.cryptomax.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.cryptomax.ui.screens.detail.navigation.detailsScreen
import com.example.cryptomax.ui.screens.exchanges.navigation.exchangesScreen
import com.example.cryptomax.ui.screens.explore.navigation.exploreScreen
import com.example.cryptomax.ui.screens.home.navigation.homeNavigationRoute
import com.example.cryptomax.ui.screens.home.navigation.homeScreen
import com.example.cryptomax.ui.screens.news.navigation.newsScreen

@Composable
fun NavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = homeNavigationRoute
) {
    androidx.navigation.compose.NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        homeScreen(navController)
        exploreScreen(navController)
        detailsScreen(navController)
        exchangesScreen(navController)
        newsScreen(navController)
    }
}