package com.example.cryptomax.ui.component.coinDetailComponent

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CoinBuySellButtons() {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(80.dp)
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Gray
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically, // Center content vertically
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