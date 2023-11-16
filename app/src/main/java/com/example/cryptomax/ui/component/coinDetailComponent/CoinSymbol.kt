package com.example.cryptomax.ui.component.coinDetailComponent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cryptomax.common.util.Consts
import com.example.cryptomax.models.coinModel.DataX

@Composable
fun CoinSymbolSection(item: DataX?) {
    Card(
        modifier = Modifier.padding(8.dp)
            .fillMaxWidth()
            .height(80.dp)
            .padding(vertical = 8.dp),
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
            AsyncImage(
                model = Consts.CryptoIconUrl + (item?.symbol?.lowercase() ?: null),
                contentDescription = "BTC",
                modifier = Modifier
                    .size(80.dp)
                    .padding(vertical = 2.dp, horizontal = 2.dp)
            )
            item?.symbol?.let {
                Text(
                    text = it.toString(),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(end = 8.dp),
                    fontSize = 14.sp,
                )
            }
        }
    }
}
