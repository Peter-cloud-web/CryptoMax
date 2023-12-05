package com.example.cryptomax.ui.component.coinDetailComponent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.North
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.cryptomax.models.coinModel.DataX
import com.example.cryptomax.common.util.ConvertCoins
import com.example.cryptomax.ui.theme.cardColor

@Composable
fun CoinSupplySection(item: DataX?) {
    item?.priceUsd.let {
        ReusableCustomInfo(
            label = "Supply",
            value = item?.supply.toString()
        )
    }
}