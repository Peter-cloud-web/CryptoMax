package com.example.cryptomax.ui.screens.explore.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.cryptomax.common.util.NavRoutes
import com.example.cryptomax.ui.screens.explore.screen.ExploreScreen

const val exploreNavigationRoute = NavRoutes.exploreCoinsRoute

fun NavController.navigateToExploration(navOptions: NavOptions? = null) {
    this.navigate(exploreNavigationRoute, navOptions)
}

fun NavGraphBuilder.exploreScreen(navController: NavController) {
    composable(route = exploreNavigationRoute) {
        ExploreScreen(navController = navController)
    }
}