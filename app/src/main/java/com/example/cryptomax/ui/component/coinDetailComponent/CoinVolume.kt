package com.example.cryptomax.ui.component.coinDetailComponent

import androidx.compose.runtime.Composable
import com.example.cryptomax.models.coinModels.Data

@Composable
fun CoinVolume24hRow(item: Data?) {
    item?.priceUsd.let {
        ReusableCustomInfo(
            label = "Volume 24H",
            value = item?.volumeUsd24Hr.toString()
        )
    }
}
  