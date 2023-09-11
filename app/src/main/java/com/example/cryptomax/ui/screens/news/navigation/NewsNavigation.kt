package com.example.cryptomax.ui.screens.news.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.cryptomax.common.util.NavRoutes
import com.example.cryptomax.ui.screens.explore.screen.ExploreScreen
import com.example.cryptomax.ui.screens.news.screen.NewsScreen


const val newsNavigationRoute = NavRoutes.coinsNewsRoute

fun NavController.navigateToNews(navOptions: NavOptions? = null) {
    this.navigate(newsNavigationRoute, navOptions)
}

fun NavGraphBuilder.newsScreen(navController: NavController) {
    composable(route = newsNavigationRoute) {
        NewsScreen(navController = navController)
    }
}