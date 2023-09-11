package com.example.cryptomax.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.cryptomax.designSystem.icon.CryptoMaxIcons

sealed  class BottomNavDestinations(
    val route: String,
    val title: String? = null,
    val iconSelected: ImageVector? = null,
    val iconUnSelected: ImageVector? = null,

){
    object HomeScreen:  BottomNavDestinations(
        route = "home_screen",
        title = "Home",
        iconSelected = CryptoMaxIcons.homeUnselected,
        iconUnSelected = CryptoMaxIcons.home
    )

    object ExchangeScreen:  BottomNavDestinations(
        route = "exchange_screen",
        title = "Exchange",
        iconSelected = CryptoMaxIcons.exchangeUnselected,
        iconUnSelected = CryptoMaxIcons.exchange
    )

    object Explore:  BottomNavDestinations(
        route = "explore_screen",
        title = "Explore",
        iconSelected = CryptoMaxIcons.exploreUnselected,
        iconUnSelected = CryptoMaxIcons.explore
    )

    object News:  BottomNavDestinations(
        route = "news_screen",
        title = "News",
        iconSelected = CryptoMaxIcons.newsUnselected,
        iconUnSelected = CryptoMaxIcons.news
    )




}