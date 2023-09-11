package com.example.cryptomax.designSystem.icon

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CurrencyExchange
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.rounded.CurrencyExchange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.material.icons.rounded.Explore
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Newspaper
import androidx.compose.ui.graphics.vector.ImageVector

object CryptoMaxIcons {
    val home = Icons.Rounded.Home
    val homeUnselected = Icons.Outlined.Home
    val exchange = Icons.Rounded.CurrencyExchange
    val exchangeUnselected = Icons.Outlined.CurrencyExchange
    val explore = Icons.Rounded.Explore
    val exploreUnselected = Icons.Outlined.Explore
    val news = Icons.Rounded.Newspaper
    val newsUnselected = Icons.Outlined.Newspaper
}

sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}