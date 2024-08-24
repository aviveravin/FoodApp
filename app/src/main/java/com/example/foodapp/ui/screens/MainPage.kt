package com.example.foodapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodapp.ui.components.CategoriesRow
import com.example.foodapp.ui.components.ExploreCard
import com.example.foodapp.ui.components.RecommendationsGrid
import com.example.foodapp.ui.components.SearchBar

@Composable
fun MainContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 80.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        // Search Bar
        SearchBar()

        Spacer(modifier = Modifier.height(16.dp))

        // Categories Row
        CategoriesRow()

        Spacer(modifier = Modifier.height(16.dp))

        // Recommendations Grid
        RecommendationsGrid()

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center){

            ExploreCard(text = "Explore all dishes")
            
            Spacer(modifier = Modifier.padding(25.dp))

            ExploreCard(text = "Confused what to cook")

        }
    }
}






@Preview
@Composable
fun PreviewMainContent() {
    MainContent()
}
