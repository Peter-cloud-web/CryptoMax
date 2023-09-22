package com.example.cryptomax.ui.component.coinDetailComponent

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.cryptomax.common.util.ConvertCoins
import com.example.cryptomax.models.coinModel.DataX

@Composable
fun CoinPriceRow(item: DataX?) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(80.dp)
            .padding(vertical = 3.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically, // Center content vertically
        ) {
            Text(
                text = "Current Price",
                style = MaterialTheme.typography.titleSmall,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            item?.priceUsd?.let {
                Text(
                    text = ConvertCoins.formatShortValue(it.toDouble()) + " $",
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(start = 140.dp),
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

}