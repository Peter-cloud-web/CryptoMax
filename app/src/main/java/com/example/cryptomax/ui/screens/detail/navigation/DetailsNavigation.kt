package com.example.cryptomax.ui.screens.detail.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.cryptomax.common.util.NavRoutes
import com.example.cryptomax.ui.screens.detail.screen.DetailScreen

const val detailsNavigationRoute = NavRoutes.coinDetailsRoute

fun NavController.navigateToDetails(navOptions: NavOptions? = null){
    this.navigate(detailsNavigationRoute,navOptions)
}

fun NavGraphBuilder.detailsScreen(navController: NavController){
    composable(route = detailsNavigationRoute){
        DetailScreen(navController = navController)
    }
}