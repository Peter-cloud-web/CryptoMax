package com.example.cryptomax.ui.screens.exchanges.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.cryptomax.common.util.NavRoutes
import com.example.cryptomax.ui.screens.exchanges.screen.ExchangeScreen

const val exchangeNavigationRoute = NavRoutes.exchangeRoute

fun NavController.navigateToExchanges(navOptions: NavOptions? = null){
    this.navigate(exchangeNavigationRoute,navOptions)
}

fun NavGraphBuilder.exchangesScreen(navController: NavController){
    composable(route = exchangeNavigationRoute){
      ExchangeScreen(navController = navController)  
    }
}