package com.example.cryptomax.ui.coins

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptomax.R
import com.google.accompanist.pager.pagerTabIndicatorOffset
import kotlinx.coroutines.launch

@Composable
fun MarketsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Markets screen",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}

@Composable
fun RatesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "RATES VIEW",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen() {
    val tabs = listOf(
        TabItem.DetailsScreen,
        TabItem.Markets,
        TabItem.Rates
    )
    val pagerState = rememberPagerState { tabs.size }
    Scaffold(
        topBar = { TopBar() },
    ) { padding ->

        Column(modifier = Modifier.padding(padding)) {
            Tabs(tabs = tabs, pagerState = pagerState)
            TabsContent(tabs = tabs, pagerState = pagerState)
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabsContent(tabs: List<TabItem>, pagerState: PagerState) {
    HorizontalPager(state = pagerState) { page ->
        tabs[page].Screen()

    }
}

@Composable
fun TopBar() {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
        ) {
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                    null,
                    modifier = Modifier
                        .clickable {}
                        .size(30.dp)
                        .clip(MaterialTheme.shapes.small)
                        .padding(2.dp)
                )

                Icon(
                    painter = painterResource(id = R.drawable.baseline_qr_code_scanner_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .clip(MaterialTheme.shapes.small)
                        .padding(2.dp)
                )

                Icon(
                    painter = painterResource(id = R.drawable.baseline_star_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .clip(MaterialTheme.shapes.small)
                        .padding(2.dp)
                )
                
                
            }


        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Tabs(tabs: List<TabItem>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    // OR ScrollableTabRow()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = colorResource(id = R.color.white),
        contentColor = Color.Green,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }) {
        tabs.forEachIndexed { index, tab ->
            // OR Tab()
            LeadingIconTab(
                icon = { Icon(painter = painterResource(id = tab.icon), contentDescription = "") },
                text = { Text(tab.title) },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MusicScreenPreview() {
    MarketsScreen()
}

@Preview(showBackground = true)
@Composable
fun RatesScreenPreview() {
    RatesScreen()
}


@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun TabsPreview() {
    val tabs = listOf(
        TabItem.DetailsScreen,
        TabItem.Rates,
        TabItem.Markets
    )
    val pagerState = rememberPagerState { tabs.size }
    Tabs(tabs = tabs, pagerState = pagerState)
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}


