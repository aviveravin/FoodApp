package com.example.foodapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodapp.R

@Composable
fun CategoryItemView(category: CategoryItem) {
    Box(
        modifier = Modifier
            .shadow(
                5.dp,
                RoundedCornerShape(100.dp)
            )
            .clip(RoundedCornerShape(100.dp))
            .background(Color.White)
            .padding(2.dp)
    ) {
        Row(modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically){
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .padding(4.dp)
            ) {
                Image(
                    painter = painterResource(id = category.imageRes),
                    contentDescription = category.label,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Text(
                text = category.label,
                color = Color.Black,
                modifier = Modifier
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun CategoriesRow() {
    val categories = listOf(
        CategoryItem(R.drawable.rice, "Rice Items"),
        CategoryItem(R.drawable.curry, "Curry Items"),
        CategoryItem(R.drawable.snacks, "Snacks Items"),
        CategoryItem(R.drawable.soups, "Soup Items"),
        CategoryItem(R.drawable.desserts, "Desserts")
    )

    LazyRow(
        modifier = Modifier.padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(categories.size) { index ->
            CategoryItemView(category = categories[index])
        }
    }
}

data class CategoryItem(val imageRes: Int, val label: String)



