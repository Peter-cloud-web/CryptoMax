package com.example.cryptomax.navigation

import com.example.cryptomax.R
import com.example.cryptomax.designSystem.icon.CryptoMaxIcons

sealed class BottomNavDestinations(
    val route: String,
    val title: String,
    val icon: Int

) {
    object HomeScreen : BottomNavDestinations(
        route = "home_screen",
        title = "Home",
        icon = R.drawable.baseline_home_24

    )

    object ExchangeScreen : BottomNavDestinations(
        route = "exchange_screen",
        title = "Exchange",
        icon = R.drawable.baseline_currency_exchange_24
    )

    object Explore : BottomNavDestinations(
        route = "explore_screen",
        title = "Explore",
        icon = R.drawable.baseline_explore_24
    )

    object News : BottomNavDestinations(
        route = "news_screen",
        title = "News",
        icon = R.drawable.baseline_newspaper_24

    )

}