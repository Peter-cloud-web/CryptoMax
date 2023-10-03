package com.example.cryptomax.ui.component.coinDetailComponent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cryptomax.common.util.ConvertCoins
import com.example.cryptomax.models.coinModel.DataX
import com.example.cryptomax.ui.theme.cardColor

@Composable
fun CoinAvailableSupply() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 5.dp, end = 5.dp, bottom = 5.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardColor
        ),
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
        ) {
            Text(
                text = "Available Supply",
                style = MaterialTheme.typography.titleSmall,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace
            )

//            item?.maxSupply?.let {
                Text(
//                    text = ConvertCoins.formatShortValue(it.toDouble()) + " $",
                    text = "756784387",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 140.dp),
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace

                )
//            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun supply(){
    CoinAvailableSupply()
}