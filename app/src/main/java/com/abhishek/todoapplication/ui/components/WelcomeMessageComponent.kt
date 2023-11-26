package com.abhishek.todoapplication.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhishek.todoapplication.R
import com.abhishek.todoapplication.ui.theme.Telex

@Composable
fun WelcomeMessage(
    modifier: Modifier = Modifier,
    userName: String,

) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Hi $userName!",
            fontFamily = Telex,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "8 tasks for today! Have a good day",
            fontFamily = Telex,
            fontSize = 16.sp,
            color = Color.LightGray
        )
    }
}