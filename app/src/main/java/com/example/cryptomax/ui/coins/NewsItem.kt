package com.example.cryptomax.ui.coins

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.cryptomax.R
import com.example.cryptomax.models.news.coinNews.Article
import com.example.cryptomax.ui.theme.cardColor


@Composable
fun NewsItem(newsArticle: Article) {
    Card(
        modifier = Modifier
            .padding(5.dp)
            .clickable {},
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardColor
        ),

        ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .width(130.dp)
                    .height(100.dp)
                // Adjust the height of the image as needed
            ) {
                val painter = rememberImagePainter(data = newsArticle.urlToImage)
                Image(
                    painter = painter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop, // Crop the image to fill the box
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.height(8.dp)) // Add spacing between image and text
            Box(
                modifier = Modifier
                    .width(120.dp) // Make the Box fill the width of the card // Align text to the top start
            ) {
                newsArticle.title?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier
                            .padding(end = 8.dp),
                        fontSize = 14.sp,
                        softWrap = true
                    )
                }
            }
        }
    }
}

