package com.example.cryptomax.ui.component.newsList

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cryptomax.models.coinNews.Article
import com.example.cryptomax.ui.coins.NewsItem
import com.example.cryptomax.ui.component.homeScreenComponents.ProgressBar
import com.example.viewModel.CoinDetailViewModel


@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun NewsList() {
    val viewModel: CoinDetailViewModel = hiltViewModel()
    val newsStates = viewModel.allArticles.collectAsState()
    newsStates.value.let { state ->
        when {
            state.isLoading -> {
                ProgressBar()
            }

            state.success != null -> {
                state.success.articles?.let { articles ->
                    NewsListItem(news = articles)
                }
            }

            state.error != null -> "An unexpected error occurred"

            else -> {}
        }

    }


}

@Composable
fun NewsListItem(news: List<Article>) {
    Text(
        modifier = Modifier.padding(12.dp),
        text = "COIN NEWS",
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold
    )
    LazyRow(contentPadding = PaddingValues(16.dp)) {
        items(news) { articles ->
            NewsItem(articles)
        }
    }

}