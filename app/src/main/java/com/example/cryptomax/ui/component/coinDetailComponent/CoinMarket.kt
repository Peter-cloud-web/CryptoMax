package com.example.cryptomax.ui.component.coinDetailComponent

import androidx.compose.runtime.Composable
import com.example.cryptomax.models.coinModels.Data

@Composable
fun CoinMarketCapRow(item: Data?) {

    item?.marketCapUsd.let {
        ReusableCustomInfo(
            label = "Market Cap",
            value = item?.marketCapUsd.toString()
        )
    }
}

