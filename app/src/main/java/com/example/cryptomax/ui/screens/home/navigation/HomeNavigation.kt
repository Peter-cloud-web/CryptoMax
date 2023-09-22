package com.example.cryptomax.ui.screens.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.cryptomax.common.util.NavRoutes
import com.example.cryptomax.ui.screens.home.screen.HomeScreen

const val homeNavigationRoute = NavRoutes.homeRoute

fun NavController.navigateToHome(navOptions: NavOptions? = null){
    this.navigate(homeNavigationRoute,navOptions)
}

//fun NavGraphBuilder.homeScreen(navController: NavController){
//    composable(route = homeNavigationRoute){
//        HomeScreen(navController = navController)
//    }
//}