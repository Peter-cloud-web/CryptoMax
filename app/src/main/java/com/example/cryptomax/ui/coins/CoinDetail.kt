package com.example.cryptomax.ui.coins

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cryptomax.models.coinNews.Article
import com.example.cryptomax.ui.component.coinDetailComponent.CoinAvailableSupply
import com.example.cryptomax.ui.component.coinDetailComponent.CoinBuySellButtons
import com.example.cryptomax.ui.component.coinDetailComponent.CoinMarketCapRow
import com.example.cryptomax.ui.component.coinDetailComponent.CoinMaxSupplyRow
import com.example.cryptomax.ui.component.coinDetailComponent.CoinPriceRow
import com.example.cryptomax.ui.component.coinDetailComponent.CoinSupplySection
import com.example.cryptomax.ui.component.coinDetailComponent.CoinSymbolSection
import com.example.cryptomax.ui.component.coinDetailComponent.CoinVolume24hRow
import com.example.cryptomax.ui.component.coinDetailComponent.LineCharts
import com.example.cryptomax.ui.component.homeScreenComponents.ProgressBar
import com.example.viewModel.uistates.CoinDetailViewModel

@RequiresApi(Build.VERSION_CODES.O)
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun CoinDetail() {
    val viewModel: CoinDetailViewModel = hiltViewModel()
    val item = viewModel.state.value?.data


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

            Text(
                text = "COIN",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )

            CoinSymbolSection(item)

            CoinSupplySection(item)

            Text(
                text = "COIN CHART",
                style = MaterialTheme.typography.bodyLarge,
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
                    text = "Statistics",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }

            CoinPriceRow(item)

            CoinMarketCapRow(item)

            CoinMaxSupplyRow(item)

            CoinVolume24hRow(item)

            CoinAvailableSupply()

            CoinBuySellButtons()


        }

    }
}

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun NewsList(){
    val viewModel: CoinDetailViewModel = hiltViewModel()
    val newsStates = viewModel.allArticles.collectAsState()
    newsStates.value.let { state ->
        when {
            state.isLoading -> {
                ProgressBar()
            }

            state.success != null -> {
                state.success.articles?.let { articles ->
                    NewsList(news = articles) }
            }

            state.error != null -> "An unexpected error occurred"

            else -> {}
        }

    }


}
@Composable
fun NewsList(news:List<Article>){
    Text(
        text = "NEWS",
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Bold
    )
    LazyRow(contentPadding = PaddingValues(16.dp)){
        items(news){articles ->
            NewsItem(articles)
        }
    }

}


//@Preview(showBackground = false)
//@Composable
//fun CoinDetailPreview() {
//    CoinDetail()
//}