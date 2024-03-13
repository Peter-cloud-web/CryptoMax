package com.example.cryptomax.ui.component.coinDetailComponent

import androidx.compose.runtime.Composable
import com.example.cryptomax.models.coinModels.Data

@Composable
fun CoinPriceRow(item: Data?) {
    item?.priceUsd.let {
        ReusableCustomInfo(
            label = "Price",
            value = item?.priceUsd.toString()
        )
    }
}
