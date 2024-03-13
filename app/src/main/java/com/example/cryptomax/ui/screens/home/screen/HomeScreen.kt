package com.example.cryptomax.ui.screens.home.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cryptomax.models.coinModels.coinListModel.Coin
import com.example.cryptomax.ui.coins.CoinItem
import com.example.cryptomax.ui.component.homeScreenComponents.Header
import com.example.cryptomax.ui.component.homeScreenComponents.ProgressBar
import com.example.viewModel.CoinViewModel

@Composable
fun HomeScreen(navController: NavController, onItemClick: (coinId: String?) -> Unit) {

    val coinViewModel: CoinViewModel = hiltViewModel()
    val allAssetsState = coinViewModel.allAssets.collectAsState()
    allAssetsState.value.let { states ->
        when {
            states.isLoading -> {
                ProgressBar()
            }

            states.success != null -> {
                CoinList(
                    coins = states.success,
                    navigationRoute = "detailsScreen",
                    onItemClick = { coinId ->
                        if (coinId != null) {
                            navController.navigate("detailsScreen/$coinId")
                        }
                    })
            }

            states.error != null -> "An unexpected error occurred"

            else -> {}
        }
    }

}

@Composable
fun CoinList(
    coins: List<Coin>,
    navigationRoute: String?,
    onItemClick: (coinId: String?) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Header()

        Text(
            text = "Assets",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
        )

        LazyColumn(
            contentPadding = PaddingValues(16.dp)
        ) {
            items(coins) { item ->
                if (navigationRoute != null) {
                    CoinItem(coin = item, navigationRoute,
                        onItemClick = {
                            onItemClick(item.id)
                        }
                    )
                }
            }
        }
    }
}




