package com.example.cryptomax.ui.component.coinDetailComponent

import androidx.compose.runtime.Composable
import com.example.cryptomax.models.coinModels.Data

@Composable
fun CoinSupplySection(item: Data?) {
    item?.priceUsd.let {
        ReusableCustomInfo(
            label = "Supply",
            value = item?.supply.toString()
        )
    }
}