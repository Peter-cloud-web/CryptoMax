package com.example.cryptomax.ui.coins

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cryptomax.ui.component.coinDetailComponent.CoinAvailableSupply
import com.example.cryptomax.ui.component.coinDetailComponent.CoinBuySellButtons
import com.example.cryptomax.ui.component.coinDetailComponent.CoinMarketCapRow
import com.example.cryptomax.ui.component.coinDetailComponent.CoinPriceRow
import com.example.cryptomax.ui.component.coinDetailComponent.CoinSupplySection
import com.example.cryptomax.ui.component.coinDetailComponent.CoinSymbolSection
import com.example.cryptomax.ui.component.coinDetailComponent.CoinVolume24hRow
import com.example.cryptomax.ui.component.coinDetailComponent.LineCharts
import com.example.cryptomax.ui.component.newsList.NewsList
import com.example.viewModel.CoinDetailViewModel

@RequiresApi(Build.VERSION_CODES.O)
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun CoinDetail() {
    val viewModel: CoinDetailViewModel = hiltViewModel()
    val item = viewModel.state.value

    Card(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(7.dp),
            horizontalAlignment = Alignment.Start
        ) {

            CoinSymbolSection(item)
            CoinSupplySection(item)

            Text(
                modifier = Modifier.padding(12.dp),
                text = "COIN CHART",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            LineCharts()
            NewsList()

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp, top = 2.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    modifier = Modifier.padding(12.dp),
                    text = "Statistics",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }

            CoinPriceRow(item)
            CoinMarketCapRow(item)
            CoinVolume24hRow(item)
            CoinAvailableSupply(item)
            CoinBuySellButtons()
        }

    }
}



