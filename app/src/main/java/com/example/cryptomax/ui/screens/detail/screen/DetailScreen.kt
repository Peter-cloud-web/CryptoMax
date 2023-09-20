package com.example.cryptomax.ui.screens.detail.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.AreaChart
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.North
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cryptomax.ui.component.LineCharts

@Composable
fun DetailScreen() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.Start
        ) {

            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.padding(10.dp)
            ) {
                AsyncImage(
                    model = null,
                    contentDescription = "BTC",
                    modifier = Modifier
                        .size(32.dp)
                        .padding(vertical = 5.dp, horizontal = 5.dp)
                )

                Text(
                    text = "BTC",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(end = 8.dp),
                    fontSize = 14.sp,
                )
            }

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.padding(10.dp)
            ) {

                Text(
                    text = "44.826,12 $",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(end = 10.dp),
                )

                Text(
                    text = "2.3%",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(start = 150.dp)

                )

                Icon(
                    imageVector = Icons.Filled.North,
                    contentDescription = null,
                    tint = Color.Green
                )
            }
        }
        Card(modifier = Modifier.padding(top = 10.dp)) {
            LineCharts()
        }

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

        Row(modifier = Modifier.padding(10.dp)) {
            Text(
                text = "Current Price",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "44,826 $",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 140.dp),
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )
        }

        Row(modifier = Modifier.padding(10.dp)) {
            Text(
                text = "Market Cap",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "567 $",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 140.dp),
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )
        }

        Row(modifier = Modifier.padding(10.dp)) {
            Text(
                text = "Max Supply",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "456,678 $",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 140.dp),
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )
        }

        Row(modifier = Modifier.padding(10.dp)) {
            Text(
                text = "Volume 24h",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "35,678 $",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 140.dp),
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )
        }
        Row(modifier = Modifier.padding(10.dp)) {
            Text(
                text = "Available Supply",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "556,456 $",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 140.dp),
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )
        }

        Row(modifier = Modifier.padding(10.dp)) {
            Text(
                text = "Available Supply",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "556,456 $",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 140.dp),
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center

        ) {

            OutlinedButton(
                onClick = { },
                modifier = Modifier.padding(8.dp),
                border = BorderStroke(2.dp, Color.Green),
                shape = RoundedCornerShape(30),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Green)
            ) {
                Text(text = "Sell")
            }


            Button(
                onClick = { },
                border = BorderStroke(1.dp, Color.White),
                shape = RoundedCornerShape(30),
                colors = ButtonDefaults.buttonColors(),
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Buy")
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun DetailScreenPreview() {
    DetailScreen()
}