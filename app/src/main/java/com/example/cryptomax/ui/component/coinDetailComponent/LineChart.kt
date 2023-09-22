package com.example.cryptomax.ui.component.coinDetailComponent

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cryptomax.common.util.LineChart
import com.example.viewModel.uistates.CoinDetailViewModel

@Composable
fun LineCharts(modifier:Modifier = Modifier){

    val viewModel: CoinDetailViewModel = hiltViewModel()
    val items = viewModel.listState

    val data = listOf(
        Pair(6, 120.45),
        Pair(7, 111.0),
        Pair(8, 113.45),
        Pair(9, 112.25),
        Pair(10, 116.45),
        Pair(11, 113.35),
        Pair(12, 118.65),
        Pair(13, 110.15),
        Pair(14, 113.05),
        Pair(15, 114.25),
        Pair(16, 116.35),
        Pair(17, 117.45)
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        LineChart(
            modifier = Modifier
                .height(200.dp)
                .width(400.dp)
                .padding(16.dp),
            data = data
        )
    }
}

@Composable
@Preview
private fun PreviewCandleChart() {
    LineCharts(
        modifier = Modifier
    )
}

