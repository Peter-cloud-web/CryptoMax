package com.example.cryptomax.ui.component.coinDetailComponent

import androidx.compose.runtime.Composable
import com.example.cryptomax.models.coinModel.DataX

@Composable
fun CoinVolume24hRow(item: DataX?) {
    item?.priceUsd.let {
        ReusableCustomInfo(
            label = "Volume 24H",
            value = item?.volumeUsd24Hr.toString()
        )
    }
}
  