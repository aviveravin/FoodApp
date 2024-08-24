package com.example.foodapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ExploreCard(text: String) {
    Box(modifier = Modifier
        .background(Color(0xFFEF6C00), RoundedCornerShape(25.dp))
        .padding(vertical = 45.dp, horizontal = 55.dp)){

        Text(text = text)

    }
}