package com.example.cryptomax.ui.coins

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptomax.models.Data
import com.example.cryptomax.ui.theme.spacing

@Composable
fun CoinItem(coin: Data) {
    val spacing = MaterialTheme.spacing
    Box(
        modifier = Modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.surfaceVariant,
                        MaterialTheme.colorScheme.surface
                    ),
                    start = Offset(0f, Float.POSITIVE_INFINITY),
                    end = Offset(Float.POSITIVE_INFINITY, 0f)
                )
            )
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(spacing.extraSmall)
            .clip(RoundedCornerShape(spacing.small))
            .shadow(elevation = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth()
        ) {
            coin.rank?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(end = 8.dp),
                    fontSize = 12.sp,
                )
            }

            Icon(
                Icons.Default.North,


            )

            coin.name?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(end = 8.dp),
                    fontSize = 12.sp,
                )
            }

            coin.priceUsd?.let { priceUsd ->
                val formattedValue  = convertDoubleValues(priceUsd)
                Text(
                    text = "$" + formattedValue,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(end = 8.dp),
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            coin.marketCapUsd?.let { marketUsd ->
                val formattedValue = convertDoubleValues(marketUsd)
                Text(
                    text =  "$" + formattedValue,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(end = 8.dp),
                    fontSize = 12.sp,
                )
            }

            coin.changePercent24Hr?.let { marketUsd ->
                val formattedValue = convertDoubleValues(marketUsd)
                Text(
                    text =  formattedValue + "%",
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.Green,
                    modifier = Modifier.padding(end = 8.dp),
                    fontSize = 12.sp,
                )
            }
        }

        Column(
            modifier = Modifier
                .padding(vertical = 13.dp, horizontal = 27.dp)
                .fillMaxWidth()
        ) {
            coin.symbol?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(end = 8.dp),
                    fontSize = 12.sp,

                    )
            }
        }
    }

    }


private fun convertDoubleValues(priceUsd: String):String{
    val stringValue = priceUsd
    val doubleValue = stringValue.toDoubleOrNull()
    val formattedValue = doubleValue?.let { String.format("%.2f", it) } ?: stringValue
    return formattedValue
}

val sampleCoin = Data(
    "0.6210807395039531",
    "https://blockchain.info/",
    "bitcoin",
    "587249815803.1976906115246936",
    "21000000.0000000000000000",
    "Bitcoin",
    "30217.1651768890862003",
    "1",
    "19434312.0000000000000000",
    "BTC",
    "3202894877.6105461814426276",
    "30050.3406268508428545"
)

@Preview(showBackground = true)
@Composable
fun CoinItemPreview() {
    CoinItem(coin = sampleCoin)
}