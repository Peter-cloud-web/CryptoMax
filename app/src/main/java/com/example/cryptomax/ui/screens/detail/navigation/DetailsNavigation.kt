package com.example.cryptomax.ui.screens.detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.example.cryptomax.common.util.NavRoutes

const val detailsNavigationRoute = NavRoutes.coinDetailsRoute

fun NavController.navigateToDetails(navOptions: NavOptions? = null){
    this.navigate(detailsNavigationRoute,navOptions)
}
//
////fun NavGraphBuilder.detailsScreen(navController: NavController){
////    composable(route = detailsNavigationRoute){
////        DetailScreen(navController = navController)
////    }
//}