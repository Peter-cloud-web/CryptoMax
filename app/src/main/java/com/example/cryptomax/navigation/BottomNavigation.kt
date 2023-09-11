package com.example.cryptomax.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable

@Composable
fun BottomNavigation() {
    val items = listOf(
        BottomNavDestinations.HomeScreen,
        BottomNavDestinations.ExchangeScreen,
        BottomNavDestinations.Explore,
        BottomNavDestinations.News
    )
    NavigationBar {
        items.forEach { item ->
            AddItem(
                screen = item
            )
        }
    }
}

fun RowScope.AddItem(
    screen: BottomNavDestinations
) {
    NavigationBarItem(
        selected = true, onClick = {
            when (screen) {

            }
        })


}