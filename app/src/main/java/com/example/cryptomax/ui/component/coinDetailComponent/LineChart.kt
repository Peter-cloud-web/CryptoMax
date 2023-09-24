package com.example.cryptomax.ui.component.coinDetailComponent

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cryptomax.common.util.LineChart
import com.example.cryptomax.models.candlesModel.Data
import com.example.viewModel.uistates.CoinDetailViewModel
import org.json.JSONObject
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import kotlin.math.pow
import kotlin.math.roundToInt

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LineCharts(modifier:Modifier = Modifier){

    val viewModel: CoinDetailViewModel = hiltViewModel()
    val items = viewModel.listState

    Log.d("Chart array", "${items}")

    val data = items.value?.map {
//        val priceUsdDouble = it.priceUsd.toDouble()
//        val priceUsdShort = priceUsdDouble.roundToInt()
        Pair(it.time.toInt(),it.priceUsd.toDouble())
    }

    Log.d("Chart array", "$data")

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        if (data != null) {
            LineChart(
                modifier = Modifier
                    .height(200.dp)
                    .width(400.dp)
                    .padding(16.dp),
                data = data
            )
        }
    }
}

fun Double.round(decimals: Int): Double {
    val multiplier = 10.0.pow(decimals.toDouble())
    return kotlin.math.round(this * multiplier) / multiplier
}

@Composable
@Preview
@RequiresApi(Build.VERSION_CODES.O)
private fun PreviewCandleChart() {
    LineCharts(
        modifier = Modifier
    )
}


