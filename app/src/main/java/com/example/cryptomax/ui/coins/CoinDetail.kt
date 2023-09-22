package com.example.cryptomax.ui.coins

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cryptomax.ui.component.coinDetailComponent.CoinAvailableSupply
import com.example.cryptomax.ui.component.coinDetailComponent.CoinBuySellButtons
import com.example.cryptomax.ui.component.coinDetailComponent.CoinMarketCapRow
import com.example.cryptomax.ui.component.coinDetailComponent.CoinMaxSupplyRow
import com.example.cryptomax.ui.component.coinDetailComponent.CoinPriceRow
import com.example.cryptomax.ui.component.coinDetailComponent.CoinSupplySection
import com.example.cryptomax.ui.component.coinDetailComponent.CoinSymbolSection
import com.example.cryptomax.ui.component.coinDetailComponent.CoinVolume24hRow
import com.example.cryptomax.ui.component.coinDetailComponent.LineCharts
import com.example.viewModel.uistates.CoinDetailViewModel

@Composable
fun CoinDetail() {
    val viewModel: CoinDetailViewModel = hiltViewModel()
    val item = viewModel.state.value?.data

    val list = viewModel.getCandleData(id)

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .verticalScroll(rememberScrollState()),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.Start
        ) {

            CoinSymbolSection(item)

            CoinSupplySection(item)

            LineCharts()

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Statistics",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }

            CoinPriceRow(item)

            CoinMarketCapRow(item)

            CoinMaxSupplyRow(item)

            CoinVolume24hRow(item)

            CoinAvailableSupply(item)

            CoinBuySellButtons()


        }

    }
}


@Preview(showBackground = false)
@Composable
fun CoinDetailPreview() {
    CoinDetail()
}