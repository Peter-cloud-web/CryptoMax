package com.example.cryptomax.ui.component.coinDetailComponent

import androidx.compose.runtime.Composable
import com.example.cryptomax.models.coinModels.Data

@Composable
fun CoinAvailableSupply(item: Data?) {
    item?.maxSupply.let {
        ReusableCustomInfo(
            label = "Max Supply",
            value = item?.maxSupply.toString()
        )
    }
}
