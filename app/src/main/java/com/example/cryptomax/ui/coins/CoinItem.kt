package com.example.cryptomax.ui.coins

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.cryptomax.common.util.Consts.CryptoIconUrl
import com.example.cryptomax.models.coinListModel.Data

@Composable
fun CoinItem(coin: Data, navigationRoute: String, onItemClick: (String) -> Unit) {

    val navController = rememberNavController()
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp)
            .clickable { onItemClick(navigationRoute) },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )

    ) {
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            AsyncImage(
                model = CryptoIconUrl + (coin.symbol?.lowercase() ?: null),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
                    .padding(vertical = 5.dp, horizontal = 5.dp)
            )

            coin.name?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(end = 8.dp),
                    fontSize = 14.sp,
                )
            }

            coin.priceUsd?.let { priceUsd ->
                val formattedValue = convertDoubleValues(priceUsd)
                Text(
                    text = "$ " + formattedValue,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 200.dp),
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }

        Row(
            modifier = Modifier
                .padding(horizontal = 40.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {

            Icon(
                imageVector = Icons.Default.North,
                contentDescription = null,
                tint = Color.Green

            )

            coin.changePercent24Hr?.let { changePercent24Hr ->
                val formattedValue = convertDoubleValues(changePercent24Hr)
                Text(
                    text = formattedValue + "%",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Green,
                    modifier = Modifier.padding(end = 8.dp),
                    fontSize = 14.sp,
                )
            }
            coin.marketCapUsd?.let { marketUsd ->
                val formattedValue = convertDoubleValues(marketUsd)
                Text(
                    text = "( $ " + formattedValue + ")",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.Green,
                    modifier = Modifier.padding(end = 8.dp),
                    fontSize = 14.sp,
                )
            }

            coin.symbol?.let { symbol ->

                Text(
                    text = symbol,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(horizontal = 25.dp)
                )
            }

        }
    }

}

private fun convertDoubleValues(priceUsd: String): String {
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

//@Preview(showBackground = true)
//@Composable
//fun CoinItemPreview() {
//    CoinItem(coin = sampleCoin,"")
//}